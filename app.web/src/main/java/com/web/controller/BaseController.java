/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

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

  protected static final List<String> WORK_EXPERIANCE = Arrays.asList(new String[] { "<1", "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "10+" });

  protected static Map<String, String> JOB_CATEGORY = new LinkedHashMap<String, String>();

  protected static Map<String, String> JOB_SUB_CATEGORY = new LinkedHashMap<String, String>();

  protected static Map<String, String> JOB_TYPE = new LinkedHashMap<String, String>();

  protected static final List<String> DESGINATION = Arrays.asList(new String[] { "Technician", "Assistant Manager",
      "Consultant", "Other" });

  protected static final List<String> EDUCATION_LIST = Arrays.asList(new String[] { "10", "10+2", "B.A", "B.Arch",
      "BCA", "B.B.A", "B.Com", "B.Ed", "BDS", "BHM", "B.Pharma", "B.Sc", "B.Tech/B.E.", "Costing",
      "Charted Accountant", "LLB", "M.A", "MBA", "MBBS", "M.Com", "MCA", "M.Sc", "M.Tech", "Diploma", "I.T.I" });

  static {
    JOB_CATEGORY.put("PUS", "Public Sector");
    JOB_CATEGORY.put("PRS", "Private Sector");
    JOB_CATEGORY.put("IJ", "Internation JOB");

    JOB_SUB_CATEGORY.put("", "");
    JOB_SUB_CATEGORY.put("CGJ", "Central Government Job");
    JOB_SUB_CATEGORY.put("SGJ", "State Government Job");
    JOB_SUB_CATEGORY.put("RJ", "Railway JOB");

    JOB_TYPE.put("PMT", "Permanent");
    JOB_TYPE.put("CNT", "Contract");
    JOB_TYPE.put("PT", "Part Time");

  }

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
  public RestResponse handleInternalServiceException(final Exception ex, final HttpServletRequest request) {
    logger.error("handleInternalServiceException-User-", ex);
    RestResponse restResponse = new RestResponse(500, ex.getMessage());
    return restResponse;
  }

  protected String getHomePage(ModelMap map) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    map.put("currentLoggedInUser", username);
    map.put("currentLoggedInUserId", user.getId());
    if (user.getUserRole().getRole().getId().equals(1L)) {
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

  public List<String> getWorkExperiance() {
    return WORK_EXPERIANCE;
  }

}
