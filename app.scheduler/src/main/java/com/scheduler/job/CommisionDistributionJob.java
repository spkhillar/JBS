package com.scheduler.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.jpa.entities.JobHistory;
import com.jpa.entities.enums.JobStatus;
import com.service.JobHistoryService;
import com.service.UserGroupService;

public class CommisionDistributionJob extends QuartzJobBean {

  private UserGroupService userGroupService;

  private JobHistoryService jobHistoryService;

  public void setJobHistoryService(JobHistoryService jobHistoryService) {
    this.jobHistoryService = jobHistoryService;
  }

  public void setUserGroupService(UserGroupService userGroupService) {
    this.userGroupService = userGroupService;
  }

  @Override
  protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
    JobHistory jobHistory = new JobHistory("CommisionDistributionJob", null, new Date(), null, JobStatus.RUNNING);
    JobHistory savedJobHistory = null;
    try {
      savedJobHistory = jobHistoryService.saveOrUpdate(jobHistory);
      Date date1 = DateUtils.addHours(new Date(), -24);
      Date startDate = DateUtils.truncate(date1, Calendar.HOUR);
      startDate = DateUtils.truncate(startDate, Calendar.MINUTE);
      startDate = DateUtils.truncate(startDate, Calendar.SECOND);
      Date endDate = DateUtils.addHours(startDate, 23);
      endDate = DateUtils.addMinutes(endDate, 59);
      endDate = DateUtils.addSeconds(endDate, 59);
      List<Long> idList = userGroupService.allocateCommision(startDate, endDate);
      if (CollectionUtils.isNotEmpty(idList)) {
        userGroupService.updateCommisionForCurrentDay(idList);
        savedJobHistory.setDescription(idList.toString());
      }
      savedJobHistory.setEndTime(new Date());
      savedJobHistory.setJobStatus(JobStatus.COMPLETED);
      jobHistoryService.saveOrUpdate(jobHistory);
    } catch (Exception e) {
      savedJobHistory.setEndTime(new Date());
      savedJobHistory.setJobStatus(JobStatus.FAILED);
      jobHistoryService.saveOrUpdate(jobHistory);
      e.printStackTrace();
    }
  }
}
