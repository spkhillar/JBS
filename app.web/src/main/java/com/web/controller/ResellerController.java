package com.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.User;
import com.jpa.entities.UserGroups;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.PaymentMode;
import com.jpa.entities.enums.UserPosition;
import com.service.DepositIntimatorService;
import com.service.MlmUserCreditPointService;
import com.service.util.ApplicationConstants;
import com.web.form.ResellerForm;
import com.web.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "/reseller")
public class ResellerController extends BaseAuthenticatedController {

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private MlmUserCreditPointService mlmUserCreditPointService;

  private static final Map<String, String> L_R_CHILD_POSITION = new HashMap<String, String>(2);

  private static final Map<String, String> L_CHILD_POSITION = new HashMap<String, String>();

  private static final Map<String, String> R_CHILD_POSITION = new HashMap<String, String>();

  static {
    L_R_CHILD_POSITION.put("0", "LEFT");
    L_R_CHILD_POSITION.put("1", "RIGHT");
    L_CHILD_POSITION.put("0", "LEFT");
    R_CHILD_POSITION.put("1", "RIGHT");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String resellerHome(final ModelMap map, final HttpServletRequest request) {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    map.put("currentLoggedInUser", username);
    map.put("currentLoggedInUserId", user.getId());
    long creditPointCount = mlmUserCreditPointService.getUserPointCount(user);
    map.put("creditPointCount", creditPointCount);
    return "mlm.home";
  }

  @RequestMapping(value = "/paymentintimator", method = RequestMethod.GET)
  public String paymentIntimator(final ModelMap map, final HttpServletRequest request) {
    ResellerForm resellerForm = new ResellerForm();
    map.put("depositIntimator", resellerForm);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "create");
    prepareResellerForm(map);
    return "mlm.payment.intimator";
  }

  @RequestMapping(value = "/paymentintimator", method = RequestMethod.POST)
  public String paymentIntimatorInitiate(final ModelMap map,
      @ModelAttribute("depositIntimator") final ResellerForm resellerForm) throws IOException {
    byte[] receiptCopy = null;
    MultipartFile multipartFile = resellerForm.getCashReceipt();
    if (multipartFile != null) {
      receiptCopy = multipartFile.getBytes();
    }
    DepositIntimator depositIntimator = resellerForm.getDepositIntimator();
    depositIntimator.setReceiptCopy(receiptCopy);
    depositIntimator.setModeOfPayment(PaymentMode.valueOf(resellerForm.getPaymentMode()));

    if (StringUtils.isNotBlank(resellerForm.getReceiverResellerId())) {
      User reseller = userService.findByMlmAccountId(resellerForm.getReceiverResellerId());
      depositIntimator.setUserByReceiverUserId(reseller);
    }

    User currentUser = userService.findByUserName(getCurrentLoggedinUserName());
    depositIntimator.setUserByUserId(currentUser);
    depositIntimator.setUpdatedAt(new Date());
    depositIntimator.setDepositIntimatorType(DepositIntimatorType.MLM_CREDIT_POINT);
    depositIntimator.setStatus(DepositIntimatorStatus.NEW);
    depositIntimatorService.save(depositIntimator);
    return "redirect:/";
  }

  @RequestMapping(value = "/register/mlm", method = RequestMethod.GET)
  public String createReseller(final ModelMap map, final HttpServletRequest request) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    userRegistrationForm.setRegistrationType(3);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "mlm_create");
    User user = getCurrentUser();
    long creditPointCount = mlmUserCreditPointService.getUserPointCount(user);
    map.put("creditPointCount", creditPointCount);
    if (creditPointCount == 2l) {
      map.put("childPositions", L_R_CHILD_POSITION);
    } else if (creditPointCount == 1l) {
      int size = user.getUserGroupsesForParentGroupId().size();
      if (size == 0) {
        map.put("childPositions", L_R_CHILD_POSITION);
      } else {
        UserGroups ug = user.getUserGroupsesForParentGroupId().iterator().next();
        if (UserPosition.L.equals(ug.getPosition())) {
          map.put("childPositions", R_CHILD_POSITION);
        } else {
          map.put("childPositions", L_CHILD_POSITION);
        }
      }
    }
    setBasicAdminRegister(map, userRegistrationForm);
    return "create.mlm.profile";
  }
}
