package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Job;
import com.jpa.entities.User;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.JobDAO;
import com.service.JobService;
import com.service.util.ServiceUtil;

@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {

  @Autowired
  private JobDAO jobDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

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

  @Override
  public Page<Job> findByCategory(String category, int page, int rows, String sortOrder, String orderByField) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sortOrder, orderByField);
    return jobDAO.findByCategory(category, pageable);
  }

  @Override
  public long findTotalMatchingJobCount(User user) {
    String query = getFilteredJobsQuery(user);
    query = " select count(j.id) from Job j where " + query;
    return genericQueryExecutorDAO.findCount(query, null);
  }

  @Override
  public Page<Job> findMatchingJob(User user, int page, int pageSize) {
    String query = getFilteredJobsQuery(user);
    query = " from Job j where " + query;
    Page<Job> filteredJobs = genericQueryExecutorDAO.executeQuery(query, Job.class, page, pageSize);
    return filteredJobs;
  }

  @Override
  public long findSiteJobCountByType(int type) {
    String jpaQuery = "select count(j.id) from Job j " + findSitePredicate(type);
    return genericQueryExecutorDAO.findCount(jpaQuery, null);
  }

  @Override
  public Page<Job> findSiteJobByType(int type, int page, int pageSize) {
    String jpaQuery = "from Job j " + findSitePredicate(type);
    return genericQueryExecutorDAO.executeQuery(jpaQuery, Job.class, page, pageSize);
  }

  public String findSitePredicate(int type) {
    String jpaPredicate = null;
    switch (type) {
    case 1:
      jpaPredicate = " where j.subCategory ='" + "CGJ" + "'";
      break;
    case 2:
      jpaPredicate = " where j.subCategory ='" + "SGJ" + "'";
      break;
    case 3:
      jpaPredicate = " where j.category ='" + "PRS" + "'";
      break;
    case 4:
      jpaPredicate =
          " where j.industry in ('" + ServiceUtil.IT_SOFTWARE_JOBS + "','" + ServiceUtil.IT_HARDWARE_JOBS + "')";
      break;
    case 5:
      jpaPredicate = " where j.industry = '" + ServiceUtil.BANK_FINANCE_JOBS + "'";
      break;
    case 6:
      jpaPredicate = " where j.subCategory ='" + "RJ" + "'";
      break;
    case 7:
      jpaPredicate = " where j.industry = '" + ServiceUtil.BANK_FINANCE_JOBS + "'";
      break;
    case 8:
      jpaPredicate = " where j.industry = '" + ServiceUtil.MARKETING_MR_MEDIA_PLANING + "'";
      break;

    default:
      throw new RuntimeException(type + " not yet implemented.");
    }
    return jpaPredicate;
  }

  private String getFilteredJobsQuery(User user) {
    String skills = user.getSkill().getSkills();
    String qualification = user.getQualifications().get(0).getDegree().getName();
    List<String> skillList = getSkillsPattern(skills);
    String qualificationCriteria = getQualificationCriteria(qualification);
    String skillCriteria = "( " + StringUtils.join(skillList, " or ") + " )";
    String finalCriteria = qualificationCriteria + " and " + skillCriteria;
    String jpaQuery = finalCriteria + " and j.enabled=1";
    return jpaQuery;
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
