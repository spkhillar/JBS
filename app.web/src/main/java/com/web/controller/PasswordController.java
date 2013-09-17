package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manage")
public class PasswordController extends BaseController {

  @RequestMapping("/forgotpassword")
  public String homePage(){
    return "user.forgotpassword";
  }

}
