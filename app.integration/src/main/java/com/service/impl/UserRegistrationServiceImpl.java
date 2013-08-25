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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Qualification;
import com.jpa.entities.Role;
import com.jpa.entities.SecurityQuestion;
import com.jpa.entities.User;
import com.jpa.entities.UserRole;
import com.jpa.entities.UserSecurityQuestion;
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
  @Transactional
  public void saveInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName) {
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

    for (Qualification qualification : newUser.getQualifications()) {
      qualification.setUser(newUser);
      qualification.setUpdatedAt(new Date());
    }
    String encodedPassword = shaPasswordEncoder.encodePassword(newUser.getPassword(), newUser.getUserName());
    newUser.setPassword(encodedPassword);
    userDao.save(newUser);
  }

  @Override
  public User retrieveUser(Long userId) {
    return userDao.findOne(userId);
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
