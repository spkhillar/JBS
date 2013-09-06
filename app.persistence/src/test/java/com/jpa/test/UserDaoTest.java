package com.jpa.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.Address;
import com.jpa.entities.Degree;
import com.jpa.entities.Qualification;
import com.jpa.entities.Role;
import com.jpa.entities.SecurityQuestion;
import com.jpa.entities.Skill;
import com.jpa.entities.User;
import com.jpa.entities.UserRole;
import com.jpa.entities.UserSecurityQuestion;
import com.jpa.repositories.DegreeDAO;
import com.jpa.repositories.RoleDAO;
import com.jpa.repositories.SecurityQuestionDAO;
import com.jpa.repositories.UserDAO;

public class UserDaoTest extends BaseTest {

  @Autowired
  private UserDAO userDao;

  @Autowired
  private SecurityQuestionDAO securityQuestionDAO;

  @Autowired
  private RoleDAO roleDAO;

  @Autowired
  private DegreeDAO degreeDAO;

  @Test
  public void testUser() throws IOException {

    InputStream is = this.getClass().getResourceAsStream("/testfile");

    if (is == null) {
      System.err.println("..not found");
    }
    byte[] resume = IOUtils.toByteArray(is);
    // ByteArrayInputStream bais = new byt
    // User user = userDao.findOne(1L);
    List<SecurityQuestion> securityQuestions = securityQuestionDAO.findAll();
    // System.err.println("..Users..."+user);

    System.err.println("..Security..." + securityQuestions);
    User newUser = new User("shiv-sambhu", "shivsambhu1234", "fname1", "lastName1", "abc@gmail.com", true, "98887655");
    Role role = roleDAO.findOne(2L);
    UserRole userRole = new UserRole(newUser, role);
    newUser.setUserRole(userRole);

    SecurityQuestion securityQuestion = securityQuestions.get(0);
    UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion(newUser, securityQuestion, "secans1");
    newUser.setUserSecurityQuestion(userSecurityQuestion);

    Address address = new Address("add1", null, "city", "state", "67777", newUser);
    newUser.setAddress(address);

    Skill skill = new Skill(newUser, "C++, Java", "IT", "4");
    skill.setUpdatedAt(new Date());
    skill.setResumeFileName("testfile");
    skill.setResume(resume);
    newUser.setSkill(skill);

    Degree degree = degreeDAO.findByName("10");

    Qualification qualification = new Qualification(newUser, degree, "CBSE", 2006, new BigDecimal("65.05"));
    qualification.setUpdatedAt(new Date());
    newUser.getQualifications().add(qualification);

    User userSaved = userDao.save(newUser);

    System.err.println("......");

  }
}
