/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.entities.Job;
import com.service.JobService;
import com.service.UserService;
import com.service.util.ServiceUtil;
import com.web.form.UserRegistrationForm;
import com.web.http.session.management.LogoutEventPublisher;

/**
 * The Class AccessController.
 * 
 * @author
 */
@Controller
public class AccessController extends BaseController {

  @Autowired
  private LogoutEventPublisher logoutEventPublisher;

  @Autowired
  private UserService userService;

  @Autowired
  private JobService jobService;

  /**
   * Login.
   * 
   * @param model
   *          the model
   * @param message
   *          the message
   * @return the string
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(final ModelMap modelMap, @RequestParam(required = false) final String message) {
    modelMap.addAttribute("message", message);
    Page<Job> privateJobList = jobService.findByCategory("PUS", 1, 5, "desc", "postedAt");
    Page<Job> publicJobList = jobService.findByCategory("PRS", 1, 5, "desc", "postedAt");
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    modelMap.put("registration", userRegistrationForm);
    modelMap.put("privateJobList", privateJobList.getContent());
    modelMap.put("publicJobList", publicJobList.getContent());
    prepareObjectsForRegistration(modelMap);
    return "site.home";
  }

  /**
   * Denied.
   * 
   * @return the string
   */
  @RequestMapping(value = "/denied", method = RequestMethod.GET)
  public String denied() {
    return "denied";
  }

  /**
   * Login failure.
   * 
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping(value = "/login/failure", method = RequestMethod.GET)
  public String loginFailure(final Model model) {
    String message = "Login Failure! Invalid User Id or Password.";
    model.addAttribute("message", message);
    return "redirect:/login";
  }

  /**
   * Logout success.
   * 
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping(value = "/logout/success", method = RequestMethod.GET)
  public String logoutSuccess(final Model model, final HttpServletRequest request) {
    String message = "Loggedout Successfully.";
    model.addAttribute("message", message);
    logoutEventPublisher.publish(request, userService.findByUserName(getCurrentLoggedinUserName()));
    return "redirect:/login";
  }

  /**
   * Logout session time out.
   * 
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping(value = "/logout/session", method = RequestMethod.GET)
  public String logoutSessionTimeOut(final Model model) {
    String message = "";
    model.addAttribute("message", message);
    return "redirect:/login";
  }

  /**
   * Logout session time out.
   * 
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping(value = "/logout/maxSession", method = RequestMethod.GET)
  public String logoutMaxSession(final Model model) {
    String message = "User already logged into the system.";
    model.addAttribute("message", message);
    return "redirect:/login";
  }

  /**
   * Session time out.
   * 
   * @return the string
   */
  @RequestMapping(value = "/sessiontimeout", method = RequestMethod.GET)
  public String sessionTimeOut() {
    return "sessiontimeout";
  }

  @Override
  protected void prepareObjectsForRegistration(final ModelMap map) {
    map.put("jobsFunctionalAreaList", userRegistrationService.getJobsFunctionalArea());
    map.put("workExperianceList", ServiceUtil.WORK_EXPERIANCE);

  }

}