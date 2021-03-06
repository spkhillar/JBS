package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.Accounts;
import com.service.AccountsService;
import com.service.UserPointsHistoryService;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/accounts")
public class AccountsController extends BaseAuthenticatedController {

  @Autowired
  private UserPointsHistoryService userPointsHistoryService;

  @Autowired
  private AccountsService accountsService;

  @RequestMapping(value = "/view/creditpoints", method = RequestMethod.GET)
  public String viewAllDeposit(final ModelMap map) {
    return "admin.creditpoint.list";
  }

  @RequestMapping(value = "/deposit/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<Accounts> mlmCreditRecords(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord) {
    Page<Accounts> accountRecords = null;

    if (search == true) {
      accountRecords = accountsService.findAll(page, rows, sord, sidx);
    } else {
      accountRecords = accountsService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(accountRecords);
    JqGridResponse<Accounts> response = new JqGridResponse<Accounts>();
    response.setRows(list);
    response.setRecords(Long.valueOf(accountRecords.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(accountRecords.getTotalPages()).toString());
    response.setPage(Integer.valueOf(accountRecords.getNumber() + 1).toString());
    return response;
  }

}
