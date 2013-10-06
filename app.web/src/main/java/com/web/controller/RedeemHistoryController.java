package com.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.enums.ModeOfRedemption;
import com.service.RedeemHistoryService;
import com.service.util.ApplicationConstants;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/admin")
public class RedeemHistoryController extends BaseAuthenticatedController {

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  private static final Map<String, String> MODE_OF_REDEEMPTION = new LinkedHashMap<String, String>();

  static {
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.CASH.toString(), "CASH");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.ACCOUNT_DEPOSIT.toString(), "DEPOSIT");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.ONLINE_TRANSFER.toString(), "ONLINE");
    MODE_OF_REDEEMPTION.put(ModeOfRedemption.CHEQUE.toString(), "CHEQUE");
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

}
