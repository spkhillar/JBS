package com.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jpa.entities.Job;
import com.jpa.entities.User;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.JobDAO;
import com.service.UserService;
import com.service.util.ServiceUtil;

public class JobServiceTest extends BaseServiceTest {

  @Autowired
  private JobDAO jobDAO;

  @Autowired
  private UserService userService;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  // @Test
  public void test1() {
    Job job =
        new Job(0, "asde", "Should have Exp..", "sdd", new Date(), "Telecom", 0, "Telcom", "asd", "4000-5000", "asd",
          "asd", "Project Manager", "asd", "Delhi", new Date(), new Date());
    job.setCategory("asd");
    jobDAO.save(job);
    Pageable page = ServiceUtil.getPage(1, 5);
    jobDAO.findByCategory("asd", page);
  }

  @Test
  public void testIfUserApplicabe() {

    User user = userService.findByUserName("shiv");
    if (user == null) {
      System.err.println("..user not found...");
    } else {
      System.err.println("..user found...");
      Page<Job> jobList = findMatchingJob(user);
      if (jobList != null) {
        System.err.println("...Job list found...");
      } else {

        System.err.println("...Job list not found...");
      }
    }

  }

  private Page<Job> findMatchingJob(User user) {
    String skills = user.getSkill().getSkills();
    String qualification = user.getQualifications().get(0).getDegree().getName();
    List<String> skillList = getSkillsPattern(skills);
    String qualificationCriteria = getQualificationCriteria(qualification);
    String skillCriteria = "( " + StringUtils.join(skillList, " or ") + " )";
    String finalCriteria = qualificationCriteria + " and " + skillCriteria;

    String jpaQuery = " from Job j where " + finalCriteria;
    Page<Job> filteredJobs = genericQueryExecutorDAO.executeQuery(jpaQuery, Job.class, 1, 10);
    return filteredJobs;
  }

  private List<String> getSkillsPattern(String skills) {
    String[] skillsArray = StringUtils.split(skills, ",");
    String jpaQuery = "j.skill like '%?1%'";
    List<String> skillList = new ArrayList<String>();
    for (String currentSkill : skillsArray) {
      skillList.add(StringUtils.replace(jpaQuery, "?1", currentSkill.trim()));
    }
    return skillList;
  }

  private String getQualificationCriteria(String qualification) {
    return "(j.qualification like '%" + qualification + "%')";
  }

}
