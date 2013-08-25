package com.service;

import java.util.List;
import java.util.Set;

import com.jpa.entities.User;

public interface UserRegistrationService {

  public Set<String> getStates();

  public List<String> getJobsFunctionalArea();

  public void saveInternetUser(User newUser, Long securityQuestionId, String securityQuestionAnswer, byte[] resume,
      String fileName);

  public User retrieveUser(Long userId);
}
