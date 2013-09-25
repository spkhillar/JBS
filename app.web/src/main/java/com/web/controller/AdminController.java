package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.enums.UserPosition;
import com.service.CommisionLevelService;
import com.service.DepositIntimatorService;
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

  private void setBasicAdminRegister(final ModelMap map, final UserRegistrationForm userRegistrationForm) {
    User existingUser = userService.findByUserName(getCurrentLoggedinUserName());
    map.put("currentLoggedInAdminId", existingUser.getId());
    map.put("registration", userRegistrationForm);
    map.put("qualificationCount", 0);
    prepareObjectsForRegistration(map);
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
}
