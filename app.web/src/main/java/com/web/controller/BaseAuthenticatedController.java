package com.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jpa.entities.User;
import com.jpa.entities.enums.PaymentMode;
import com.web.form.UserRegistrationForm;
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

  protected void prepareResellerForm(final ModelMap map) {
    List<String> paymentModes =
        Arrays.asList(new String[] { PaymentMode.CHEQUE.toString(), PaymentMode.DEPOSIT.toString(),
            PaymentMode.MANUAL.toString(), PaymentMode.ONLINE.toString() });
    map.put("paymentModes", paymentModes);
  }

  protected void setBasicAdminRegister(final ModelMap map, final UserRegistrationForm userRegistrationForm) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    map.put("currentLoggedInAdminId", existingUser.getId());
    map.put("registration", userRegistrationForm);
    map.put("qualificationCount", 0);
    prepareObjectsForRegistration(map);
  }

}
