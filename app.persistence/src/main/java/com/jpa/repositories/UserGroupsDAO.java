/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.User;
import com.jpa.entities.UserGroups;

/**
 * The Interface RoleDAO.
 * 
 * @author
 */
public interface UserGroupsDAO extends JpaRepository<UserGroups, Long> {

  UserGroups findByUserByGroupId(User userByGroupId);

}
