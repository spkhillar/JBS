package com.web.controller;

import java.util.Locale;
import java.util.Map;

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
import com.service.SecurityQuestionService;
import com.service.UserRegistrationService;
import com.service.UserService;
import com.web.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "/normal/user")
public class NormalUserController extends BaseController {

  @Autowired
  private UserRegistrationService userRegistrationService;

  @Autowired
  private SecurityQuestionService securityQuestionService;

  @Autowired
  private UserService userService;

  @Autowired
  private JobService jobService;

  @RequestMapping(value = "/retrieveuser/{userId}", method = RequestMethod.GET)
  public String retrieveUser(ModelMap map, final HttpServletRequest request, @PathVariable Long userId) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    User existingUser = userRegistrationService.retrieveUser(userId);
    userRegistrationForm.setUser(existingUser);
    userRegistrationForm.setSecurityQuestion(existingUser.getUserSecurityQuestion().getSecurityQuestion().getId());
    userRegistrationForm.setSecurityAnswer(existingUser.getUserSecurityQuestion().getAnswer());
    userRegistrationForm.setDegree(existingUser.getQualifications().get(0).getDegree().getName());
    userRegistrationForm.setTerms(true);
    map.put("registration", userRegistrationForm);
    map.put("currentLoggedInUserId", existingUser.getId());
    map.put("qualifications", existingUser.getQualifications());
    map.put("qualificationCount", existingUser.getQualifications().size() - 1);
    prepareObjectsForRendering(map);
    return "normal.user.profile";
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(final Locale locale, final ModelMap map) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    map.put("currentLoggedInUser", username);
    map.put("currentLoggedInUserId", user.getId());
    Page<Job> jobServiceList = jobService.findALL(1, 10, "desc", "postedAt");
    map.put("jobList", jobServiceList.getContent());
    return "normal.user.home";
  }

  private void prepareObjectsForRendering(ModelMap map) {
    Map<String, String> questionMap = securityQuestionService.getSecurityQuestions();
    map.put("securityQuestions", questionMap);
    map.put("states", userRegistrationService.getStates());
    map.put("jobsFunctionalAreaList", userRegistrationService.getJobsFunctionalArea());
    map.put("workExperianceList", this.getWorkExperiance());
    map.put("degreeList", userRegistrationService.getDegrees());
  }

}
