package com.service;

import java.util.List;
import java.util.Set;

import com.jpa.entities.User;
import com.jpa.entities.enums.UserPosition;

public interface UserRegistrationService {

  public Set<String> getStates();

  public List<String> getJobsFunctionalArea();

  public void saveInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree);

  public User retrieveUser(Long userId);

  public List<String> getDegrees();

  public void updateInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree);

  public void saveAdminUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree);

  public User saveMlmUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree, long roleId, UserPosition userPosition, String parentMlmAccountId);

  User saveMlmUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName, String degree, long roleId);

}
