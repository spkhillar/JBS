package com.web.controller;

import java.io.IOException;
import java.util.Date;

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
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.PaymentMode;
import com.service.DepositIntimatorService;
import com.service.util.ApplicationConstants;
import com.web.form.ResellerForm;

@Controller
@RequestMapping(value = "/reseller")
public class ResellerController extends BaseAuthenticatedController {

  @Autowired
  private DepositIntimatorService depositIntimatorService;

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

}
