package com.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.User;
import com.service.SecurityQuestionService;
import com.service.UserRegistrationService;
import com.web.form.UserRegistrationForm;

@Controller()
@RequestMapping("/register")
public class UserRegistrationController extends BaseController {

  @Autowired
  private SecurityQuestionService securityQuestionService;

  @Autowired
  private UserRegistrationService userRegistrationService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String register(final ModelMap map, final HttpServletRequest request) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    map.put("registration", userRegistrationForm);
    map.put("qualificationCount", 0);
    prepareObjectsForRendering(map);
    return "newuser";
  }

  @RequestMapping(value = "/retrieveuser/{userId}", method = RequestMethod.GET)
  public String retrieveUser(final ModelMap map, final HttpServletRequest request, @PathVariable final Long userId) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    User existingUser = userRegistrationService.retrieveUser(userId);
    userRegistrationForm.setUser(existingUser);
    userRegistrationForm.setSecurityQuestion(existingUser.getUserSecurityQuestion().getSecurityQuestion().getId());
    userRegistrationForm.setSecurityAnswer(existingUser.getUserSecurityQuestion().getAnswer());
    userRegistrationForm.setDegree(existingUser.getQualifications().get(0).getDegree().getName());
    map.put("registration", userRegistrationForm);
    map.put("currentLoggedInUserId", existingUser.getId());
    map.put("qualifications", existingUser.getQualifications());
    map.put("qualificationCount", existingUser.getQualifications().size() - 1);
    prepareObjectsForRendering(map);
    return "newuser";
  }

  private void prepareObjectsForRendering(final ModelMap map) {
    Map<String, String> questionMap = securityQuestionService.getSecurityQuestions();
    map.put("securityQuestions", questionMap);
    map.put("states", userRegistrationService.getStates());
    map.put("jobsFunctionalAreaList", userRegistrationService.getJobsFunctionalArea());
    map.put("workExperianceList", this.getWorkExperiance());
    map.put("degreeList", userRegistrationService.getDegrees());

  }

  @RequestMapping(value = "/newuser", method = RequestMethod.POST)
  public String registerNewUser(@ModelAttribute("registration") final UserRegistrationForm userRegistrationForm,
      final ModelMap map, final HttpServletRequest request) throws IOException {
    byte[] resume = null;
    String fileName = null;
    MultipartFile multipartFile = userRegistrationForm.getResume();
    if (multipartFile != null) {
      resume = multipartFile.getBytes();
      fileName = multipartFile.getOriginalFilename();
    }
    userRegistrationService.saveInternetUser(userRegistrationForm.getUser(),
      userRegistrationForm.getSecurityQuestion(), userRegistrationForm.getSecurityAnswer(), resume, fileName,
      userRegistrationForm.getDegree());
    return "redirect:/";
  }

  @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
  public String updateUser(@ModelAttribute("registration") final UserRegistrationForm userRegistrationForm, final ModelMap map,
      final HttpServletRequest request) throws IOException {
    byte[] resume = null;
    String fileName = null;
    MultipartFile multipartFile = userRegistrationForm.getResume();
    if (multipartFile != null) {
      resume = multipartFile.getBytes();
      fileName = multipartFile.getOriginalFilename();
    }
    userRegistrationService.updateInternetUser(userRegistrationForm.getUser(),
      userRegistrationForm.getSecurityQuestion(), userRegistrationForm.getSecurityAnswer(), resume, fileName,
      userRegistrationForm.getDegree());
    return getHomePage(map);
  }

  @RequestMapping(value = "/view/terms")
  public String viewTermsAndCondition() {

    return "termsandcondition";
  }

}
