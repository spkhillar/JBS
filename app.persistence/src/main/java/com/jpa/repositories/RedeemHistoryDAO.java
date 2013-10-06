/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.enums.RedeemStatus;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface RedeemHistoryDAO extends JpaRepository<RedeemHistory, Long> {

  public Page<RedeemHistory> findByStatus(RedeemStatus status, Pageable pageable);

}
