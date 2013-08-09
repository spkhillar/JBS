/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.jpa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.JobHistory;

/**
 * The Interface JobHistoryDAO.
 * 
 * @author 
 */
public interface JobHistoryDAO extends JpaRepository<JobHistory, Long> {

  List<JobHistory> findByJobNameAndStartTimeBetween(String jobName,
    Date startDate, Date endDate);

  JobHistory findById(Long id);

}
