package com.web.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.entities.SecurityQuestion;
import com.jpa.entities.User;
import com.jpa.entities.UserSecurityQuestion;
import com.service.SecurityQuestionService;
import com.service.UserService;
import com.web.form.UserRegistrationForm;

@Controller
@RequestMapping("/manage")
public class PasswordController extends BaseController {

  @Autowired
  private SecurityQuestionService securityQuestionService;

  @Autowired
  private UserService userService;

  @RequestMapping("/forgotpassword")
  public String homePage(final ModelMap map) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    map.put("registration", userRegistrationForm);
    prepareRenderObject(map);
    return "user.forgotpassword";
  }

  @RequestMapping(value = "/forgotpwd/password", method = RequestMethod.POST)
  public String forgotPassword(final ModelMap map,
      @ModelAttribute("registration") final UserRegistrationForm userRegistrationForm, BindingResult result) {
    validateUserFormForPassword(userRegistrationForm, result);
    if (result.hasErrors()) {
      map.put("registration", userRegistrationForm);
      prepareRenderObject(map);
      return "user.forgotpassword";
    }
    userService.changePassword(userRegistrationForm.getUser().getUserName(), userRegistrationForm.getUser()
      .getPassword());
    return "redirect:/login";
  }

  @RequestMapping(value = "/forgotpwd/username", method = RequestMethod.POST)
  public String forgotUsername(final ModelMap map,
      @ModelAttribute("registration") final UserRegistrationForm userRegistrationForm, BindingResult result) {
    String username = validateUserFormForUserName(userRegistrationForm, result);
    if (result.hasErrors()) {
      map.put("registration", userRegistrationForm);
      prepareRenderObject(map);
      return "user.forgotpassword";
    }
    userService.changePassword(username, userRegistrationForm.getUser().getPassword());
    return "redirect:/login";
  }

  @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
  public String changePassword(final ModelMap map,
      @ModelAttribute("registration") final UserRegistrationForm userRegistrationForm, BindingResult result) {
    boolean matchPassword =
        userService.matchPassword(getCurrentLoggedinUserName(), userRegistrationForm.getUser().getPassword(),
          userRegistrationForm.getNewPassword());
    if (matchPassword) {
      return "redirect:/j_spring_security_logout";
    }
    result.addError(new ObjectError("registration", "Password does not match with the password in the system"));
    String currentUserHome = getHomePage(map);
    String showView = null;
    User currentUser = userService.findByUserName(getCurrentLoggedinUserName());
    if (StringUtils.equals(currentUserHome, "admin.home")) {
      showView = "redirect:/admin/changepassword/" + currentUser.getId();
    } else {
      showView = "redirect:/normal/user/changepassword/" + currentUser.getId();
    }
    return showView;
  }

  private void prepareRenderObject(ModelMap map) {
    Map<String, String> questionMap = securityQuestionService.getSecurityQuestions();
    Map<String, String> modifiedQuestionMap = new LinkedHashMap<String, String>();
    modifiedQuestionMap.put("-1", "");
    modifiedQuestionMap.putAll(questionMap);
    map.put("securityQuestions", modifiedQuestionMap);
  }

  private String validateUserFormForUserName(UserRegistrationForm userRegistrationForm, BindingResult result) {
    String firstName = userRegistrationForm.getUser().getFirstName();
    String lastName = userRegistrationForm.getUser().getLastName();
    String emailAddress = userRegistrationForm.getUser().getEmail();
    String phoneNumber = userRegistrationForm.getUser().getPhone();
    User user = userService.findUserBy(firstName, lastName, emailAddress, phoneNumber);
    String username = null;
    if (user == null) {
      result.addError(new ObjectError("registration", "User doesnot exists with given userid"));
      return username;
    }
    username = user.getUserName();
    checkUserSecurityQuestion(user, userRegistrationForm, result);
    return username;
  }

  private void validateUserFormForPassword(UserRegistrationForm userRegistrationForm, BindingResult result) {
    User user = userService.findByUserName(userRegistrationForm.getUser().getUserName());
    if (user == null) {
      result.addError(new ObjectError("registration", "User doesnot exists with given userid"));
    }
    checkUserSecurityQuestion(user, userRegistrationForm, result);
  }

  private void checkUserSecurityQuestion(User user, UserRegistrationForm userRegistrationForm, BindingResult result) {
    Long nullQuestion = new Long(-1l);
    if (!nullQuestion.equals(userRegistrationForm.getSecurityQuestion())) {
      UserSecurityQuestion userSecurityQuestion = user.getUserSecurityQuestion();
      SecurityQuestion securityQuestion = userSecurityQuestion.getSecurityQuestion();
      if (userRegistrationForm.getSecurityQuestion().longValue() != securityQuestion.getId()) {
        result.addError(new ObjectError("registration", "Security Question doesnot match."));
      } else if (!StringUtils.equals(userRegistrationForm.getSecurityAnswer(), userSecurityQuestion.getAnswer())) {
        result.addError(new ObjectError("registration", "Security Answer doesnot match."));
      }
    }
  }

}
