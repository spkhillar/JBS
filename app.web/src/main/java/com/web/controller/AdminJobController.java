package com.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminJobController extends BaseController {

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AdminJobController.class);

  @RequestMapping(value = "/job/new", method = RequestMethod.GET)
  public String newJob(final Locale locale, final ModelMap map) {
    return "admin.new.job";
  }

}
