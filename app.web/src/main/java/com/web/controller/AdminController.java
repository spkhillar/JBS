package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.entities.User;
import com.web.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

  @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
  public String changePassword(final ModelMap map, final HttpServletRequest request) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    map.put("currentLoggedInAdminId", existingUser.getId());
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    map.put("registration", userRegistrationForm);
    return "admin.changepassword";
  }

  @RequestMapping(value = "/register/admin", method = RequestMethod.GET)
  public String createAdmin(final ModelMap map, final HttpServletRequest request) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    map.put("currentLoggedInAdminId", existingUser.getId());
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    userRegistrationForm.setRegistrationType(1);
    map.put("registration", userRegistrationForm);
    map.put("qualificationCount", 0);
    prepareObjectsForRegistration(map);
    return "create.admin.profile";
  }

  @RequestMapping(value = "/commission/list", method = RequestMethod.GET)
  public String listCommission() {
    return "admin.list.commission";
  }
}
