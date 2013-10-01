package com.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.entities.Job;
import com.jpa.entities.User;
import com.service.JobService;
import com.service.util.ApplicationConstants;
import com.web.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "/normal/user")
public class NormalUserController extends BaseAuthenticatedController {

  @Autowired
  private JobService jobService;

  @RequestMapping(value = "/retrieveuser", method = RequestMethod.GET)
  public String retrieveUser(final ModelMap map, final HttpServletRequest request) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    retrieveAndPopulateUser(map, existingUser);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "user_update");
    return "normal.user.profile";
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(final Locale locale, final ModelMap map) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    map.put("currentLoggedInUser", username);
    map.put("currentLoggedInUserId", user.getId());
    map.put("currentLoggedInUserEmail", user.getEmail());
    map.put("currentLoggedInUserMobile", user.getPhone());
    map.put("currentLoggedInUserSkill", user.getSkill().getSkills());
    map.put("currentLoggedInUserExperience", user.getSkill().getYearOfExperiance());
    map.put("currentLoggedInUserFunctionalArea", user.getSkill().getFunctionalArea());
    return "normal.user.home";
  }

  @RequestMapping(value = "/joblist/{page}/{pageSize}", method = RequestMethod.GET)
  public String getJobListForUser(final ModelMap map, @PathVariable final int page, @PathVariable final int pageSize) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    map.put("currentLoggedInUser", username);
    map.put("currentLoggedInUserId", user.getId());
    Page<Job> jobServiceList = jobService.findMatchingJob(user, page, pageSize);
    map.put("jobList", jobServiceList.getContent());
    return "viewjobs";
  }

  @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
  public String changePassword(final ModelMap map, final HttpServletRequest request) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    map.put("currentLoggedInUserId", existingUser.getId());
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    map.put("registration", userRegistrationForm);
    return "user.changepassword";
  }


}
