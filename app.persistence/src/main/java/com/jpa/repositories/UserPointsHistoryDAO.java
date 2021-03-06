/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.User;
import com.jpa.entities.UserPointsHistory;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface UserPointsHistoryDAO extends JpaRepository<UserPointsHistory, Long> {

  public Page<UserPointsHistory> findByUser(User user, Pageable page);

  public Page<UserPointsHistory> findByUserAndEnabled(User user, boolean enabled, Pageable page);

  public Page<UserPointsHistory> findByUserIn(List<User> user, Pageable page);

}
