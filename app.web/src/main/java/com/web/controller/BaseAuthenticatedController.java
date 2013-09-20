package com.web.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.service.util.ApplicationConstants;
import com.web.form.WebUser;

public class BaseAuthenticatedController extends BaseController {

  public User getCurrentUser() {
    String userName = getCurrentLoggedinUserName();
    User user = userService.findByUserName(userName);
    return user;
  }

  @ModelAttribute("webUser")
  public WebUser getWebUser() {
    User user = getCurrentUser();
    WebUser webUser =
        new WebUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
    checkForMlmAdminUsers(user, webUser);
    return webUser;
  }

  private void checkForMlmAdminUsers(User user, WebUser webUser) {
    Long roleId = user.getUserRole().getRole().getId();
    if (roleId.equals(1L)) {
      SystemConfiguration systemConfiguration =
          systemConfigurationService.findByKeyAndValue(ApplicationConstants.ROOT_MLM_1,
            ApplicationConstants.BOOLEAN_FALSE_STRING);
      if (systemConfiguration == null) {
        webUser.setAdminMlmLeft(true);
      }
      systemConfiguration =
          systemConfigurationService.findByKeyAndValue(ApplicationConstants.ROOT_MLM_2,
            ApplicationConstants.BOOLEAN_FALSE_STRING);
      if (systemConfiguration == null) {
        webUser.setAdminMlmRight(true);
      }
    }
  }

}
