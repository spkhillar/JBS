/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.SystemConfiguration;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface SystemConfigurationDAO extends JpaRepository<SystemConfiguration, Long> {

  public SystemConfiguration findByKey(String key);

  public SystemConfiguration findByKeyAndValue(String key, String value);

}
