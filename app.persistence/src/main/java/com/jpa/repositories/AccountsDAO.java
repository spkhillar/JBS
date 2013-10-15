/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.Accounts;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface AccountsDAO extends JpaRepository<Accounts, Long> {

}
