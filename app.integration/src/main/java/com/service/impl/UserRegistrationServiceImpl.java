package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Address;
import com.jpa.entities.Degree;
import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.Qualification;
import com.jpa.entities.Role;
import com.jpa.entities.SecurityQuestion;
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.UserRole;
import com.jpa.entities.UserSecurityQuestion;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.MlmUserCreditPointStatus;
import com.jpa.entities.enums.UserPosition;
import com.jpa.repositories.DegreeDAO;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.RoleDAO;
import com.jpa.repositories.SecurityQuestionDAO;
import com.jpa.repositories.UserDAO;
import com.service.MlmUserCreditPointService;
import com.service.SystemConfigurationService;
import com.service.UserGroupService;
import com.service.UserRegistrationService;
import com.service.util.ApplicationConstants;
import com.service.util.ServiceUtil;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private UserDAO userDao;

  @Autowired
  private SecurityQuestionDAO securityQuestionDAO;

  @Autowired
  private RoleDAO roleDAO;

  /** The sha password encoder. */
  @Autowired
  private ShaPasswordEncoder shaPasswordEncoder;

  @Autowired
  private DegreeDAO degreeDAO;

  private Set<String> states = new TreeSet<String>();

  @Autowired
  private UserGroupService userGroupService;

  @Autowired
  private SystemConfigurationService systemConfigurationService;

  @Autowired
  private MlmUserCreditPointService mlmUserCreditPointService;

  @Override
  public Set<String> getStates() {
    return states;
  }

  @Override
  public List<String> getJobsFunctionalArea() {
    List<String> jobsFunctionalAreaList =
        genericQueryExecutorDAO.executeProjectedQuery("select j.name from JobsFunctionalArea j order by j.name");
    return jobsFunctionalAreaList;
  }

  @Override
  public List<String> getDegrees() {
    List<String> degreeList =
        genericQueryExecutorDAO.executeProjectedQuery("select d.name from Degree d order by d.name");
    return degreeList;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void saveInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree) {
    Role role = roleDAO.findOne(2L);
    UserRole userRole = new UserRole(newUser, role);
    saveUser(newUser, securityQuestionId, securityQuestionAnswer, resume, fileName, degree, userRole);
  }

  @Override
  @Transactional
  public void saveAdminUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree) {
    Role role = roleDAO.findOne(5L);
    UserRole userRole = new UserRole(newUser, role);
    saveUser(newUser, securityQuestionId, securityQuestionAnswer, resume, fileName, degree, userRole);
  }

  @Override
  @Transactional
  public User saveMlmUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree, long roleId) {
    Role role = roleDAO.findOne(roleId);
    UserRole userRole = new UserRole(newUser, role);
    newUser.setMlmAccountId(getMlmAccountId());
    User savedUser = saveUser(newUser, securityQuestionId, securityQuestionAnswer, resume, fileName, degree, userRole);
    return savedUser;
  }

  @Override
  @Transactional
  public User saveMlmUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree, long roleId, UserPosition userPosition, String parentMlmAccountId) {
    Role role = roleDAO.findOne(roleId);
    UserRole userRole = new UserRole(newUser, role);
    newUser.setMlmAccountId(getMlmAccountId());
    User savedUser = saveUser(newUser, securityQuestionId, securityQuestionAnswer, resume, fileName, degree, userRole);
    userGroupService.addToGroup(savedUser, parentMlmAccountId, userPosition);
    if (StringUtils.isBlank(parentMlmAccountId)) {
      updateSystemConfigProperties(userPosition);
    } else {
      User parentUser = userDao.findByMlmAccountId(parentMlmAccountId);
      List<MlmUserCreditPoint> mlmUserCreditPoints =
          mlmUserCreditPointService.listMlmUserCreditPoint(parentUser, MlmUserCreditPointStatus.OPEN,
            DepositIntimatorStatus.APPROVED);
      if (CollectionUtils.isEmpty(mlmUserCreditPoints)) {
        throw new UnsupportedOperationException("User does not have any open records in MlmUserCreditPoint. ");
      }
      MlmUserCreditPoint mlmUserCreditPoint = mlmUserCreditPoints.get(0);
      mlmUserCreditPointService.updateStatus(mlmUserCreditPoint, MlmUserCreditPointStatus.CLOSED);
    }
    return savedUser;
  }

  private String getMlmAccountId() {
    String mlmAccountId = null;
    boolean exist = true;
    while (exist) {
      int accountId = ServiceUtil.mlmAccountId();
      mlmAccountId = ApplicationConstants.MLM_ACCOUNT_PREFEIX + accountId;
      User user = userDao.findByMlmAccountId(mlmAccountId);
      if (user == null) {
        exist = false;
      }
    }
    return mlmAccountId;
  }

  private User saveUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree, UserRole userRole) {

    newUser.setUserRole(userRole);
    SecurityQuestion securityQuestion = securityQuestionDAO.findOne(securityQuestionId);
    UserSecurityQuestion userSecurityQuestion =
        new UserSecurityQuestion(newUser, securityQuestion, securityQuestionAnswer);
    newUser.setUserSecurityQuestion(userSecurityQuestion);
    userSecurityQuestion.setUpdatedAt(new Date());
    newUser.getAddress().setUpdatedAt(new Date());
    // for admin user
    if (newUser.getSkill() != null) {
      newUser.getSkill().setResume(resume);
      newUser.getSkill().setResumeFileName(fileName);
      newUser.getSkill().setUpdatedAt(new Date());
    }
    // For admin user
    if (CollectionUtils.isNotEmpty(newUser.getQualifications())) {
      Qualification qualification = newUser.getQualifications().get(0);
      Degree savedDegree = degreeDAO.findByName(degree);
      qualification.setDegree(savedDegree);
      qualification.setUser(newUser);
      qualification.setUpdatedAt(new Date());
    }
    String encodedPassword = shaPasswordEncoder.encodePassword(newUser.getPassword(), newUser.getUserName());
    newUser.setPassword(encodedPassword);
    return userDao.save(newUser);
  }

  @Override
  public User retrieveUser(Long userId) {
    return userDao.findOne(userId);
  }

  @Override
  @Transactional
  public void updateUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree) {
    User dbUser = this.retrieveUser(newUser.getId());

    SecurityQuestion securityQuestion = securityQuestionDAO.findOne(securityQuestionId);
    UserSecurityQuestion userSecurityQuestion = dbUser.getUserSecurityQuestion();
    if (!securityQuestionId.equals(userSecurityQuestion.getSecurityQuestion().getId())) {
      userSecurityQuestion.setSecurityQuestion(securityQuestion);
      userSecurityQuestion.setAnswer(securityQuestionAnswer);
      userSecurityQuestion.setUpdatedAt(new Date());
    }
    if (!StringUtils.equals(securityQuestionAnswer, userSecurityQuestion.getAnswer())) {
      userSecurityQuestion.setAnswer(securityQuestionAnswer);
      userSecurityQuestion.setUpdatedAt(new Date());
    }
    Address dbAddress = dbUser.getAddress();
    Address currAddress = newUser.getAddress();
    BeanUtils.copyProperties(currAddress, dbAddress, new String[] { "id", "version", "createdAt", "user" });
    dbAddress.setUpdatedAt(new Date());
    if (StringUtils.isNotBlank(fileName) && dbUser.getSkill() != null) {
      dbUser.getSkill().setResume(resume);
      dbUser.getSkill().setResumeFileName(fileName);
    }
    // For admin user and mlm admin user
    if (dbUser.getSkill() != null && newUser.getSkill() != null) {
      dbUser.getSkill().setSkills(newUser.getSkill().getSkills());
      dbUser.getSkill().setUpdatedAt(new Date());
      Qualification currQualification = newUser.getQualifications().get(0);
      Qualification dbQualification = dbUser.getQualifications().get(0);
      Degree savedDegree = dbQualification.getDegree();

      if (!StringUtils.equals(degree, savedDegree.getName())) {
        Degree currDegree = degreeDAO.findByName(degree);
        dbQualification.setDegree(currDegree);
      }
      BeanUtils.copyProperties(currQualification, dbQualification, new String[] { "id", "version", "createdAt", "user",
          "degree" });
      dbQualification.setUpdatedAt(new Date());
    }
    dbUser.setFirstName(newUser.getFirstName());
    dbUser.setEmail(newUser.getEmail());
    dbUser.setLastName(newUser.getLastName());
    dbUser.setPhone(newUser.getPhone());
    dbUser.setSignedForNotification(newUser.isSignedForNotification());
    userDao.save(dbUser);
  }

  private void updateSystemConfigProperties(UserPosition userPosition) {
    SystemConfiguration systemConfiguration = null;
    if (UserPosition.L.equals(userPosition)) {
      systemConfiguration = systemConfigurationService.findByKey(ApplicationConstants.ROOT_MLM_1);
    } else {
      systemConfiguration = systemConfigurationService.findByKey(ApplicationConstants.ROOT_MLM_2);
    }
    systemConfiguration.setValue(ApplicationConstants.BOOLEAN_TRUE_STRING);
    systemConfigurationService.update(systemConfiguration);
  }

  @PostConstruct
  public void initUserRegistrationService() throws IOException {
    InputStream is = this.getClass().getResourceAsStream("state.properties");
    Properties props = new Properties();
    props.load(is);
    // Set<String> currentStates = new TreeSet<String>();
    for (final Entry<Object, Object> entry : props.entrySet()) {
      // states.put((String) entry.getKey(), (String) entry.getValue());
      states.add((String) entry.getValue());
    }
  }
}
