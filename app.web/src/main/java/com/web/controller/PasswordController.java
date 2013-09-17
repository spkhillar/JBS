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
    return null;
  }

  private void prepareRenderObject(ModelMap map) {
    Map<String, String> questionMap = securityQuestionService.getSecurityQuestions();
    Map<String, String> modifiedQuestionMap = new LinkedHashMap<String, String>();
    modifiedQuestionMap.put("-1", "");
    modifiedQuestionMap.putAll(questionMap);
    map.put("securityQuestions", modifiedQuestionMap);
  }

  private void validateUserFormForPassword(UserRegistrationForm userRegistrationForm, BindingResult result) {
    User user = userService.findByUserName(userRegistrationForm.getUser().getUserName());
    Long nullQuestion = new Long(-1l);
    if (user == null) {
      result.addError(new ObjectError("registration", "User doesnot exists with given userid"));
    } else if (!nullQuestion.equals(userRegistrationForm.getSecurityQuestion())) {
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
