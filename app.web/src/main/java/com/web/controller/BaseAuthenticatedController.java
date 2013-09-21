package com.web.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.jpa.entities.User;
import com.web.form.WebUser;

public class BaseAuthenticatedController extends BaseController {

  public User getCurrentUser() {
    String userName = getCurrentLoggedinUserName();
    User user = userService.findByUserName(userName);
    return user;
  }

  @ModelAttribute("webUser")
  public WebUser getWebUser() {
    User user;
    WebUser webUser = null;
    try {
      user = getCurrentUser();
      webUser =
          new WebUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
    } catch (Exception e) {
      webUser = new WebUser();
    }
    return webUser;
  }

}
