package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class PageController extends BaseController {

  @RequestMapping("/page1")
  public String page1Example(){
    return "index";
  }

  @RequestMapping("/page2")
  public String page2Example(){
    return "test2";
  }


}
