package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.CommisionLevel;
import com.service.CommisionLevelService;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/commission")
public class CommisionLevelController extends BaseAuthenticatedController {

  @Autowired
  private CommisionLevelService commisionLevelService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String listCommission() {
    return "admin.list.commission";
  }

  @RequestMapping(value = "/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<CommisionLevel> records(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord) {
    Page<CommisionLevel> commisionLevels = null;
    if (search == true) {
      commisionLevels = commisionLevelService.findAll(page, rows, sord, sidx);
    } else {
      commisionLevels = commisionLevelService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(commisionLevels);
    JqGridResponse<CommisionLevel> response = new JqGridResponse<CommisionLevel>();
    response.setRows(list);
    response.setRecords(Long.valueOf(commisionLevels.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(commisionLevels.getTotalPages()).toString());
    response.setPage(Integer.valueOf(commisionLevels.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateCommission(CommisionLevel commisionLevel) {
    commisionLevelService.update(commisionLevel);
    return "updated";
  }
}
