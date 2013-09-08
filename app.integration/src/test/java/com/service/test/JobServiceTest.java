package com.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.jpa.entities.Job;
import com.jpa.entities.User;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.JobDAO;
import com.service.JobService;
import com.service.UserService;
import com.service.util.ServiceUtil;

public class JobServiceTest extends BaseServiceTest {

  @Autowired
  private JobDAO jobDAO;

  @Autowired
  private UserService userService;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private JobService jobService;

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

  // @Test
  public void testIfUserApplicabe() {
    User user = userService.findByUserName("shiv");
    jobService.findMatchingJob(user, 1, 10);
  }

  @Test
  public void testFindSiteJobCountByType() {

    for (int i = 1; i < 9; i++) {
      long count = jobService.findSiteJobCountByType(i);
      System.err.println(i + "..count.." + count);
    }

  }

}
