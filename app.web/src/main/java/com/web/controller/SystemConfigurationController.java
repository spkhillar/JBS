package com.web.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.SystemConfiguration;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/systemconfiguration")
public class SystemConfigurationController extends BaseAuthenticatedController {

  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public String viewSystemConfiguration() {
    return "admin.view.systemconfiguration";
  }

  @RequestMapping(value = "/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<SystemConfiguration> systemConfigRecords(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord) {
    Page<SystemConfiguration> systemConfiguration = null;
    if (search == true) {
      systemConfiguration = systemConfigurationService.findAll(page, rows, sord, sidx);
    } else {
      systemConfiguration = systemConfigurationService.findAll(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(systemConfiguration);
    JqGridResponse<SystemConfiguration> response = new JqGridResponse<SystemConfiguration>();
    response.setRows(list);
    response.setRecords(Long.valueOf(systemConfiguration.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(systemConfiguration.getTotalPages()).toString());
    response.setPage(Integer.valueOf(systemConfiguration.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateSystemConfiguration(SystemConfiguration systemConfiguration) {
    systemConfigurationService.update(systemConfiguration);
    return "Updated";
  }

}
