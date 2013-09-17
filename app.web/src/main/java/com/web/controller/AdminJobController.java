package com.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.entities.Job;
import com.jpa.entities.User;
import com.service.JobService;
import com.service.UserRegistrationService;
import com.service.util.ServiceUtil;
import com.web.form.JobForm;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

@Controller
@RequestMapping(value = "/admin")
public class AdminJobController extends BaseController {

  @Autowired
  private UserRegistrationService userRegistrationService;

  @Autowired
  private JobService jobService;

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AdminJobController.class);

  @RequestMapping(value = "/job/list", method = RequestMethod.GET)
  public String listJobs() {
    return "admin.list.job";
  }

  @RequestMapping(value = "/job/new", method = RequestMethod.GET)
  public String newJob(final ModelMap map) {
    JobForm jobForm = new JobForm();
    map.put("jobForm", jobForm);
    map.put("savedDegreeList", new ArrayList<String>());
    map.put("availableDegreeList", userRegistrationService.getDegrees());
    prepareJobRenderer(map);
    return "admin.new.job";
  }

  @RequestMapping(value = "/job/post", method = RequestMethod.POST)
  public String postJob(final ModelMap map, @ModelAttribute("jobForm") final JobForm jobForm) {
    Job newJob = jobForm.getJob();
    String qualification = jobForm.getSelectedDegreeList();
    newJob.setQualification(qualification);
    if (StringUtils.isNotBlank(jobForm.getOtherDesignation())) {
      newJob.setDesignation(jobForm.getOtherDesignation());
    } else {
      newJob.setDesignation(jobForm.getDesignation());
    }
    if (jobForm.isNewJob()) {
      logger.debug("Saving new Job Record");
      jobService.saveJob(newJob);
    } else {
      logger.debug("Updating new Record");
      jobService.updateJob(newJob);
    }
    return "redirect:/admin/job/list";
  }

  @RequestMapping(value = "/job/find/{jobId}", method = RequestMethod.GET)
  public String findJob(@PathVariable final long jobId, final ModelMap map) {
    JobForm jobForm = new JobForm();
    Job existingJob = jobService.findJob(jobId);
    jobForm.setJob(existingJob);
    String designation = existingJob.getDesignation();

    if (!ServiceUtil.DESGINATION.contains(designation)) {
      jobForm.setOtherDesignation(designation);
      jobForm.setDesignation("Other");
    } else {
      jobForm.setDesignation(designation);
    }
    jobForm.setNewJob(false);
    map.put("jobForm", jobForm);
    prepareJobRenderer(map);

    List<String> selectedDegree = Arrays.asList(StringUtils.split(existingJob.getQualification(), ","));
    map.put("savedDegreeList", selectedDegree);
    map.put("availableDegreeList", ListUtils.subtract(userRegistrationService.getDegrees(), selectedDegree));
    return "admin.new.job";
  }

  @RequestMapping(value = "/job/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<Job> records(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {
    Page<Job> jobs = null;
    if (search == true) {
      jobs = jobService.findALL(page, rows, sord, sidx);
    } else {
      jobs = jobService.findALL(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(jobs);
    JqGridResponse<Job> response = new JqGridResponse<Job>();
    response.setRows(list);
    response.setRecords(Long.valueOf(jobs.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(jobs.getTotalPages()).toString());
    response.setPage(Integer.valueOf(jobs.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/job/view/{jobId}", method = RequestMethod.GET)
  public String viewJobDetials(@PathVariable final long jobId, final ModelMap map) {
    Job currentJob = jobService.findJob(jobId);
    map.put("currentJob", currentJob);
    return "jobdescription";
  }

  @RequestMapping(value = "/job/apply/{jobId}", method = RequestMethod.GET)
  @ResponseBody
  public String applyToJob(@PathVariable final long jobId) {
    this.getCurrentLoggedinUserName();
    Job currentJob = jobService.findJob(jobId);
    if (StringUtils.isBlank(currentJob.getCompanyJobUrl())) {
      return currentJob.getCompanyUrl();
    }
    return currentJob.getCompanyJobUrl();
  }

  @RequestMapping(value = "/job/currentuser", method = RequestMethod.GET)
  @ResponseBody
  public long jobsForCurrentUser() {
    String username = this.getCurrentLoggedinUserName();
    User user = userService.findByUserName(username);
    long totalCount = jobService.findTotalMatchingJobCount(user);
    return totalCount;
  }

  @RequestMapping(value = "/job/site/{type}", method = RequestMethod.GET)
  @ResponseBody
  public long jobsForCurrentUser(@PathVariable final int type) {
    long totalCount = jobService.findSiteJobCountByType(type);
    return totalCount;
  }

  @RequestMapping(value = "/job/site/detail/{type}", method = RequestMethod.GET)
  public String siteJobs(final ModelMap map, @PathVariable final int type) {
    map.put("currrentJobType", type);
    return "site.jobs";
  }

  @RequestMapping(value = "/job/site/details/{type}/{page}/{pageSize}", method = RequestMethod.GET)
  public String siteJobDetails(final ModelMap map, @PathVariable final int type, @PathVariable final int page,
      @PathVariable final int pageSize) {
    Page<Job> jobServiceList = jobService.findSiteJobByType(type, page, pageSize);
    map.put("jobList", jobServiceList.getContent());
    map.put("currrentJobType", type);
    return "viewjobs";
  }

  private void prepareJobRenderer(final ModelMap map) {
    map.put("jobTypes", ServiceUtil.JOB_TYPE);
    map.put("jobCategories", ServiceUtil.JOB_CATEGORY);
    map.put("jobSubCategories", ServiceUtil.JOB_SUB_CATEGORY);
    map.put("jobDesignations", ServiceUtil.DESGINATION);
    map.put("jobsFunctionalAreaList", userRegistrationService.getJobsFunctionalArea());
    map.put("workExperianceList", ServiceUtil.WORK_EXPERIANCE);

  }

  @RequestMapping(value = "/changepassword/{userId}", method = RequestMethod.GET)
  public String changePassword(final ModelMap map, final HttpServletRequest request, @PathVariable final Long userId) {
    User existingUser = userRegistrationService.retrieveUser(userId);
    map.put("currentLoggedInAdminId", existingUser.getId());
    return "admin.changepassword";
  }

}
