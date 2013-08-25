package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class PageController extends BaseController {

  @RequestMapping("/page1")
  public String homePage(){
    return "index";
  }

  @RequestMapping("/register")
  public String registrationPage(){
    return "newuser";
  }

  @RequestMapping("/login")
  public String loginPage(){
    return "login";
  }

  @RequestMapping("/enquiry")
  public String enquiryPage(){
    return "enquiry";
  }
  @RequestMapping("/aboutus")
  public String aboutPage(){
    return "aboutus";
  }

  @RequestMapping("/admincontrol")
  public String adminPage(){
    return "adminhome";
  }

}
