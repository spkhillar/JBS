package com.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.SystemConfiguration;
import com.service.DepositIntimatorService;
import com.service.RedeemHistoryService;
import com.service.util.ApplicationConstants;
import com.web.form.ResellerForm;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/admin")
public class DepositIntimatorController extends BaseAuthenticatedController {

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  @RequestMapping(value = "/deposit/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<DepositIntimator> mlmDepositRecords(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord) {
    Page<DepositIntimator> depositIntimator = null;
    if (search == true) {
      depositIntimator = depositIntimatorService.findAll(page, rows, sord, sidx);
    } else {
      depositIntimator = depositIntimatorService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(depositIntimator);
    JqGridResponse<DepositIntimator> response = new JqGridResponse<DepositIntimator>();
    response.setRows(list);
    response.setRecords(Long.valueOf(depositIntimator.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(depositIntimator.getTotalPages()).toString());
    response.setPage(Integer.valueOf(depositIntimator.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/view/approval/notification/{depositorIntimatorId}", method = RequestMethod.GET)
  public String viewDepositNotification(@PathVariable final long depositorIntimatorId, final ModelMap map) {
    ResellerForm resellerForm = new ResellerForm();
    DepositIntimator depositIntimator = depositIntimatorService.findById(depositorIntimatorId);
    resellerForm.setPaymentMode(depositIntimator.getModeOfPayment().toString());
    if (depositIntimator.getUserByReceiverUserId() != null) {
      resellerForm.setReceiverResellerId(depositIntimator.getUserByReceiverUserId().getMlmAccountId());
    }
    resellerForm.setDepositIntimator(depositIntimator);
    map.put("depositIntimator", resellerForm);
    prepareResellerForm(map);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "view");

    return "deposit-intimator";
  }

  @RequestMapping(value = "/approve/notification/{depositorIntimatorId}/{type}", method = RequestMethod.POST)
  @ResponseBody
  public String approveOrRejectDepositIntimator(@RequestBody String memo,
      @PathVariable final long depositorIntimatorId, @PathVariable final int type, final ModelMap map) {
    depositIntimatorService.approveOrRejectDepositIntimator(depositorIntimatorId, type, memo);
    return "done with approval";
  }

  @RequestMapping(value = "/verify/{depositorAmount}", method = RequestMethod.GET)
  @ResponseBody
  public String verifyAmount(@PathVariable final BigDecimal depositorAmount, final ModelMap map) {
    SystemConfiguration systemConfiguration =
        systemConfigurationService.findByKey(ApplicationConstants.SUBSCRIPTION_BASE_PRICE);
    BigDecimal divisor = new BigDecimal(systemConfiguration.getValue());

    if (depositorAmount.intValue() < divisor.intValue()) {
      return "Amount should be in multiples of " + systemConfiguration.getValue() + ".";
    }
    BigDecimal reminder = depositorAmount.remainder(divisor);
    if (reminder.intValue() > 0) {
      return "Amount should be in multiples of " + systemConfiguration.getValue() + ".";
    }
    return "";
  }

  @RequestMapping(value = "/credit/transfer/{depositAmount}/{commissionAmount}/{resellerId}", method = RequestMethod.POST)
  @ResponseBody
  public String creditTransfer(@PathVariable final BigDecimal depositAmount,
      @PathVariable final BigDecimal commissionAmount, @PathVariable final String resellerId, final ModelMap map) {
    redeemHistoryService.createCreditTransferRecord(depositAmount, commissionAmount, resellerId,
      getCurrentLoggedinUserName());
    return "";
  }
}
