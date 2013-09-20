package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.User;
import com.service.UserGroupService;
import com.web.form.UserRegistrationForm;

@Controller()
@RequestMapping("/register")
public class UserRegistrationController extends BaseController {

  @Autowired
  private UserGroupService userGroupService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String register(final ModelMap map, final HttpServletRequest request) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    map.put("registration", userRegistrationForm);
    map.put("qualificationCount", 0);
    prepareObjectsForRegistration(map);
    return "user.registration";
  }

  @RequestMapping(value = "/retrieveuser/{userId}", method = RequestMethod.GET)
  public String retrieveUser(final ModelMap map, final HttpServletRequest request, @PathVariable final Long userId) {
    retrieveAndPopulateUser(map);
    return "newuser";
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

    if (userRegistrationForm.getRegistrationType() == 2) {
      userRegistrationService.saveInternetUser(userRegistrationForm.getUser(),
        userRegistrationForm.getSecurityQuestion(), userRegistrationForm.getSecurityAnswer(), resume, fileName,
        userRegistrationForm.getDegree());
    } else if (userRegistrationForm.getRegistrationType() == 3) {
      User savedMlmUser =
          userRegistrationService.saveMlmUser(userRegistrationForm.getUser(),
            userRegistrationForm.getSecurityQuestion(), userRegistrationForm.getSecurityAnswer(), resume, fileName,
            userRegistrationForm.getDegree());
      User currentUser = userService.findByUserName(getCurrentLoggedinUserName());
      Long roleId = currentUser.getUserRole().getRole().getId();
      if (roleId.equals(1L)) {
        // userGroupService.addToGroup(savedMlmUser, null, position)
      }
    } else if (userRegistrationForm.getRegistrationType() == 5) {
      userRegistrationService.saveAdminUser(userRegistrationForm.getUser(), userRegistrationForm.getSecurityQuestion(),
        userRegistrationForm.getSecurityAnswer(), resume, fileName, userRegistrationForm.getDegree());
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
  public String updateUser(@ModelAttribute("registration") final UserRegistrationForm userRegistrationForm,
      final ModelMap map, final HttpServletRequest request) throws IOException {
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

  @RequestMapping(value = "/checkUserName/{userName}", method = RequestMethod.GET)
  @ResponseBody
  public boolean checkUserName(@PathVariable final String userName) {
    User user = userService.findByUserName(userName);
    if (user == null) {
      return false;
    }
    return true;
  }
}
