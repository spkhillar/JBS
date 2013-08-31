package com.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Job;
import com.jpa.repositories.JobDAO;
import com.service.JobService;
import com.service.util.ServiceUtil;

@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {

  @Autowired
  private JobDAO jobDAO;

  @Override
  public void saveJob(Job job) {
    job.setEnabled(true);
    job.setUpdatedAt(new Date());
    jobDAO.save(job);
  }

  @Override
  public void updateJob(Job jobToUpdate) {
    Job savedJob = findJob(jobToUpdate.getId());
    BeanUtils.copyProperties(jobToUpdate, savedJob, new String[] { "createdAt", "version" });
    savedJob.setUpdatedAt(new Date());
    jobDAO.save(savedJob);
  }

  @Override
  public Page<Job> findALL(int page, int rows, String sortOrder, String orderByField) {
    return jobDAO.findAll(ServiceUtil.getPage(page, rows, sortOrder, orderByField));
  }

  @Override
  public Job findJob(Long id) {
    return jobDAO.findOne(id);
  }

}
