/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.CommisionLevel;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface CommisionLevelDAO extends JpaRepository<CommisionLevel, Long> {

  public CommisionLevel findByLevel(int level);

}
