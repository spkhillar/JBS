package com.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jpa.entities.User;
import com.jpa.entities.enums.PaymentMode;
import com.service.DepositIntimatorService;
import com.service.UserPointsHistoryService;
import com.web.form.UserRegistrationForm;
import com.web.form.WebUser;

public class BaseAuthenticatedController extends BaseController {

  @Autowired
  private UserPointsHistoryService userPointsHistoryService;

  @Autowired
  private DepositIntimatorService depositIntimatorService;


  public User getCurrentUser() {
    String userName = getCurrentLoggedinUserName();
    User user = userService.findByUserName(userName);
    return user;
  }

  @ModelAttribute("webUser")
  public WebUser getWebUser() {
    User user;
    Integer currentBalance=0;
    Integer currentComissionBalance=0;
    WebUser webUser = null;
    try {
      user = getCurrentUser();
      if(user.getRoleId().equals(3L) && user.getRoleId().equals(6L)){
        currentBalance=depositIntimatorService.getBalanceDeposit(user);
        currentComissionBalance=userPointsHistoryService.getUserTotalCommsionPoint(user);
      }
      webUser =
          new WebUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(),user.getMlmAccountId(), currentBalance.toString(), currentComissionBalance.toString());
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
