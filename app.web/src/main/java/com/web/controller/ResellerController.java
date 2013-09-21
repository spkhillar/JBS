package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/reseller")
public class ResellerController extends BaseAuthenticatedController {


  @RequestMapping(value = "/paymentintimator", method = RequestMethod.GET)
  public String paymentIntimator(final ModelMap map, final HttpServletRequest request) {
    return "mlm.payment.intimator";
  }


}
