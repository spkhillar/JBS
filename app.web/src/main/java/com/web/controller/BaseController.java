/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jpa.entities.User;
import com.service.UserService;
import com.web.rest.RestResponse;

/**
 * The Class BaseController.
 * 
 * @author
 */
public class BaseController {

  @Autowired
  protected UserService userService;

  @InitBinder
  public void initBinder(final WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

  /**
   * Handle internal service exception.
   * 
   * @param ex
   *          the ex
   * @param request
   *          the request
   * @return the rest response
   */
  @ExceptionHandler(Throwable.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public RestResponse handleInternalServiceException(final Exception ex, final HttpServletRequest request) {
    logger.error("handleInternalServiceException-User-", ex);
    RestResponse restResponse = new RestResponse(500, ex.getMessage());
    return restResponse;
  }

  protected String getHomePage(ModelMap map) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    if (user.getUserRole().getRole().getId().equals(1L)) {
      map.put("currentLoggedInUser", username);
      map.put("currentLoggedInUserId", user.getId());
      return "admin.home";
    } else {
      return "redirect:/normal/user/home";
    }
  }

  public String getCurrentLoggedinUserName() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    org.springframework.security.core.userdetails.User principal =
        (org.springframework.security.core.userdetails.User) auth.getPrincipal();
    String username = principal.getUsername();
    return username;
  }

}
