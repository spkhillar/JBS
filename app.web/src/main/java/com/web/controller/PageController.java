package com.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.entities.Job;

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

  @RequestMapping("/userhome")
  public String userPage(){
    return "userhome";
  }

  @RequestMapping("/admincontrol")
  public String adminPage(){
    return "adminhome";
  }

  @RequestMapping("/viewjob")
  public String viewjobPage(final ModelMap map){
    List<Job> jobList=new ArrayList<Job>();
    Job job=new Job(0, "","Should have Exp..","",new Date(),"Telecom",0,"Telcom","","4000-5000",
      "", "", "Project Manager","", "Delhi", null, null);
    jobList.add(job);
    map.put("jobList", jobList);


    return "viewjobs";
  }

  @RequestMapping("/jobdetail")
  public String jobDescription(){
    return "jobdescription";
  }



}
