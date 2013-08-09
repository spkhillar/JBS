/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.web.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.rest.RestResponse;
import com.web.rest.WebHomeData;

/**
 * Handles requests for the application home page.
 * 
 * @author 
 */
@Controller
public class HomeController {

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory
      .getLogger(HomeController.class);

  /**
   * Simply selects the home view to render by returning its name.
   * 
   * @param locale
   *            the locale
   * @param model
   *            the model
   * @return the string
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(final Locale locale, final Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
      DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "home";
  }

  /**
   * android rest login.
   * 
   * @return the home data object
   */
  @RequestMapping(value = "/rest/auth", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  private RestResponse restAuth() {
    return new RestResponse(0, "Logged In");
  }

  /**
   * android rest login.
   * 
   * @return the home data object
   */
  @RequestMapping(value = "/rest/webHomeData", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public WebHomeData chartData() {
	  List<Integer> chartExample = new ArrayList<Integer>();
	  chartExample.add(10);
	  chartExample.add(20);
	  chartExample.add(5);
	  chartExample.add(50);
	  
    WebHomeData webHomeData = new WebHomeData();
    webHomeData.setChartData(chartExample);
    return webHomeData;
  }

  @RequestMapping(value = "/underconstruction", method = RequestMethod.GET)
  public String underConstruction() {
    return "under.construction";
  }

}
