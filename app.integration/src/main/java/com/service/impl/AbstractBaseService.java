/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.UserService;
import com.service.util.ApplicationServiceException;
import com.jpa.entities.User;

/**
 * The Class AbstractBaseService.
 *
 * @author 
 */
public abstract class AbstractBaseService {

  /** The user service. */
  @Autowired
  protected UserService userService;

  /**
   * Gets the user.
   *
   * @param username the username
   * @return the user
   */
  public User getUser(final String username) {
    User user = userService.findByUserName(username);
    if (user == null) {
      throw new ApplicationServiceException("User " + username
        + "not found in system");
    }
    return user;
  }
}
