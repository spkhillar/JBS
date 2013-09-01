/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.Job;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface JobDAO extends JpaRepository<Job, Long> {

  public Page<Job> findByCategory(String category, Pageable pageable);

  public Page<Job> findBySubCategory(String category, Pageable pageable);

}
