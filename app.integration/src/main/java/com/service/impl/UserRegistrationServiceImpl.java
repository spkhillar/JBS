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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Address;
import com.jpa.entities.Degree;
import com.jpa.entities.Qualification;
import com.jpa.entities.Role;
import com.jpa.entities.SecurityQuestion;
import com.jpa.entities.User;
import com.jpa.entities.UserRole;
import com.jpa.entities.UserSecurityQuestion;
import com.jpa.repositories.DegreeDAO;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.RoleDAO;
import com.jpa.repositories.SecurityQuestionDAO;
import com.jpa.repositories.UserDAO;
import com.service.UserRegistrationService;

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
  @Transactional
  public void saveInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree) {
    Role role = roleDAO.findOne(2L);
    UserRole userRole = new UserRole(newUser, role);
    newUser.setUserRole(userRole);
    SecurityQuestion securityQuestion = securityQuestionDAO.findOne(securityQuestionId);
    UserSecurityQuestion userSecurityQuestion =
        new UserSecurityQuestion(newUser, securityQuestion, securityQuestionAnswer);
    newUser.setUserSecurityQuestion(userSecurityQuestion);
    userSecurityQuestion.setUpdatedAt(new Date());
    newUser.getAddress().setUpdatedAt(new Date());

    newUser.getSkill().setResume(resume);
    newUser.getSkill().setResumeFileName(fileName);
    newUser.getSkill().setUpdatedAt(new Date());

    Qualification qualification = newUser.getQualifications().get(0);
    Degree savedDegree = degreeDAO.findByName(degree);
    qualification.setDegree(savedDegree);
    qualification.setUser(newUser);
    qualification.setUpdatedAt(new Date());
    String encodedPassword = shaPasswordEncoder.encodePassword(newUser.getPassword(), newUser.getUserName());
    newUser.setPassword(encodedPassword);
    userDao.save(newUser);
  }

  @Override
  public User retrieveUser(Long userId) {
    return userDao.findOne(userId);
  }

  @Override
  @Transactional
  public void updateInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
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
    if (StringUtils.isNotBlank(fileName)) {
      dbUser.getSkill().setResume(resume);
      dbUser.getSkill().setResumeFileName(fileName);
    }
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
    dbUser.setFirstName(newUser.getFirstName());
    dbUser.setEmail(newUser.getEmail());
    dbUser.setLastName(newUser.getLastName());
    dbUser.setPhone(newUser.getPhone());
    userDao.save(dbUser);
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
