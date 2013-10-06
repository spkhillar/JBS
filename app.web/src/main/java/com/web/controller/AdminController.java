package com.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.Payment;
import com.jpa.entities.RedeemHistory;
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.enums.ModeOfRedemption;
import com.jpa.entities.enums.UserPosition;
import com.service.CommisionLevelService;
import com.service.DepositIntimatorService;
import com.service.PaymentService;
import com.service.RedeemHistoryService;
import com.service.SystemConfigurationService;
import com.service.UserGroupService;
import com.service.util.ApplicationConstants;
import com.web.form.ResellerForm;
import com.web.form.UserRegistrationForm;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseAuthenticatedController {

  @Autowired
  private CommisionLevelService commisionLevelService;

  @Autowired
  private SystemConfigurationService systemConfigurationService;

  @Autowired
  private UserGroupService userGroupService;

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  @Autowired
  private PaymentService paymentService;


  private static final Map<String, String> MODE_OF_REDEEMPTION = new LinkedHashMap<String, String>();

  static {
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.CASH.toString(), "CASH");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.ACCOUNT_DEPOSIT.toString(), "DEPOSIT");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.ONLINE_TRANSFER.toString(), "ONLINE");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.CHEQUE.toString(), "CHEQUE");
  }

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
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    userRegistrationForm.setRegistrationType(5);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "site_admin");
    setBasicAdminRegister(map, userRegistrationForm);
    return "create.admin.profile";
  }

  @RequestMapping(value = "/register/mlm/{position}", method = RequestMethod.GET)
  public String createMlmAdmin(final ModelMap map, final HttpServletRequest request, @PathVariable final int position) {
    SystemConfiguration systemConfiguration = null;
    if (position == 0) {
      systemConfiguration =
          systemConfigurationService.findByKeyAndValue(ApplicationConstants.ROOT_MLM_1,
            ApplicationConstants.BOOLEAN_TRUE_STRING);
    } else {
      systemConfiguration =
          systemConfigurationService.findByKeyAndValue(ApplicationConstants.ROOT_MLM_2,
            ApplicationConstants.BOOLEAN_TRUE_STRING);
    }
    if (systemConfiguration == null) {
      return checkAndReturnCreateView(map, position);
    } else {
      return retrieveAdminMlmAndReturnView(map, position);
    }
  }

  private String retrieveAdminMlmAndReturnView(final ModelMap map, final int position) {
    User user = userService.findByUserName(getCurrentLoggedinUserName());
    UserPosition userPosition = position == 0 ? UserPosition.L : UserPosition.R;
    User mlmUser = userGroupService.findMlmAdminUser(user, userPosition);
    retrieveAndPopulateUser(map, mlmUser);
    return "admin.mlm.profile";
  }

  private String checkAndReturnCreateView(final ModelMap map, final int position) {
    UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
    userRegistrationForm.setRegistrationType(6);
    userRegistrationForm.setMlmPosition(position);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "site_admin");
    setBasicAdminRegister(map, userRegistrationForm);
    return "create.admin.profile";
  }

  @RequestMapping(value = "/view/reseller", method = RequestMethod.GET)
  public String viewReseller() {
    return "admin.view.reseller";
  }

  @RequestMapping(value = "/view/deposit", method = RequestMethod.GET)
  public String viewAllDeposit(final ModelMap map) {
    return "payment.deposit.list";
  }

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
    if (depositIntimator.getUserByReceiverUserId() == null) {
      resellerForm.setDepositIntimator(depositIntimator);
    }
    resellerForm.setPaymentMode(depositIntimator.getModeOfPayment().toString());
    if (depositIntimator.getUserByReceiverUserId() != null) {
      resellerForm.setReceiverResellerId(depositIntimator.getUserByReceiverUserId().getMlmAccountId());
    }

    map.put("depositIntimator", resellerForm);
    prepareResellerForm(map);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "view");

    return "deposit-intimator";
  }

  @RequestMapping(value = "/approve/notification/{depositorIntimatorId}/{type}", method = RequestMethod.GET)
  @ResponseBody
  public String approveOrRejectDepositIntimator(@PathVariable final long depositorIntimatorId,
      @PathVariable final int type, final ModelMap map) {
    depositIntimatorService.approveOrRejectDepositIntimator(depositorIntimatorId, type);
    return "done with approval";
  }

  @RequestMapping(value = "/commision/{startDate}", method = RequestMethod.GET)
  public String commision(@PathVariable final String startDate, final ModelMap map, final HttpServletRequest request)
      throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Date start = sdf.parse(startDate);
    Date finaldate = DateUtils.addHours(start, 23);
    finaldate = DateUtils.addMinutes(finaldate, 59);
    finaldate = DateUtils.addSeconds(finaldate, 59);
    userGroupService.allocateCommision(start, finaldate);
    return "good";
  }

  @RequestMapping(value = "/redeem/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<RedeemHistory> mlmRedeemRecords(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {
    Page<RedeemHistory> redeemHistory = null;
    if (search == true) {
      redeemHistory = redeemHistoryService.findAll(page, rows, sord, sidx);
    } else {
      redeemHistory = redeemHistoryService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(redeemHistory);
    JqGridResponse<RedeemHistory> response = new JqGridResponse<RedeemHistory>();
    response.setRows(list);
    response.setRecords(Long.valueOf(redeemHistory.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(redeemHistory.getTotalPages()).toString());
    response.setPage(Integer.valueOf(redeemHistory.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/view/redeem", method = RequestMethod.GET)
  public String viewAllRedeem(final ModelMap map) {
    return "redeem.history.list";
  }

  @RequestMapping(value = "/view/redeem/notification/{id}", method = RequestMethod.GET)
  public String viewRedeemNotification(@PathVariable final long id, final ModelMap map) {
    RedeemHistory redeemHistory = redeemHistoryService.findById(id);
    map.put("resellerRedeemForm", redeemHistory);
    map.put("modeOfRedemptionList", MODE_OF_REDEEMPTION);
    map.put(ApplicationConstants.USER_OPERATION_ON_SCREEN, "view");
    return "reseller-redemption";
  }

  @RequestMapping(value = "/approve/redeem/notification/{id}/{approval}", method = RequestMethod.GET)
  public String approveOrRejectNotification(@PathVariable final long id, @PathVariable final int approval,
      final ModelMap map) {
    redeemHistoryService.approveOrRejectNotification(id, approval);
    return "redeem.history.list";
  }

  @RequestMapping(value = "/payment/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<Payment> paymentRecords(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {
    Page<Payment> payment = null;
    if (search == true) {
      payment = paymentService.findAll(page, rows, sord, sidx);
    } else {
      payment = paymentService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(payment);
    JqGridResponse<Payment> response = new JqGridResponse<Payment>();
    response.setRows(list);
    response.setRecords(Long.valueOf(payment.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(payment.getTotalPages()).toString());
    response.setPage(Integer.valueOf(payment.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/view/payment", method = RequestMethod.GET)
  public String viewAllPayment(final ModelMap map) {
    return "payment.list";
  }

}
