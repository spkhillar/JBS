/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.Degree;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface DegreeDAO extends JpaRepository<Degree, Long> {

  public Degree findByName(String name);

}
