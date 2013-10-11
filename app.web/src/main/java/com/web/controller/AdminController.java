package com.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.enums.UserPosition;
import com.service.CommisionLevelService;
import com.service.DepositIntimatorService;
import com.service.SystemConfigurationService;
import com.service.UserGroupService;
import com.service.UserService;
import com.service.util.ApplicationConstants;
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
  private UserService userService;

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

  @RequestMapping(value = "/view/redeem", method = RequestMethod.GET)
  public String viewAllRedeem(final ModelMap map) {
    return "redeem.history.list";
  }


  @RequestMapping(value = "/view/payment", method = RequestMethod.GET)
  public String viewAllPayment(final ModelMap map) {
    return "payment.list";
  }

  @RequestMapping(value = "/view/userdetails", produces = "application/json")
  public @ResponseBody
  JqGridResponse<User> viewUsers(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {
    long role=2l;
    Page<User> userList = null;
    if (search == true) {
      userList = userService.findByUserRoleId(role, page, rows, sord, sidx);
    } else {
      userList = userService.findByUserRoleId(role, page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(userList);
    JqGridResponse<User> response = new JqGridResponse<User>();
    response.setRows(list);
    response.setRecords(Long.valueOf(userList.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(userList.getTotalPages()).toString());
    response.setPage(Integer.valueOf(userList.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/view/users", method = RequestMethod.GET)
  public String viewAllUsers(final ModelMap map) {
    return "user.list";
  }

}
