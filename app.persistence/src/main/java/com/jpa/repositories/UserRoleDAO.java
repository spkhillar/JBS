/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.UserRole;

/**
 * The Interface UserRoleDAO.
 *
 * @author  
 */
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

}
