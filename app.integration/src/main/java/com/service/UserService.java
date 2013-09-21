/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.jpa.entities.Role;
import com.jpa.entities.User;

/**
 * The Interface UserService.
 * 
 * @author
 */
public interface UserService extends BaseService<User> {

  /**
   * Find all.
   * 
   * @param page
   *          the page
   * @param rows
   *          the rows
   * @param sortOrder
   *          the sort order
   * @param orderByField
   *          the order by field
   * @return the page
   */
  Page<User> findALL(int page, int rows, String sortOrder, String orderByField);

  /**
   * Find all.
   * 
   * @return the list
   */
  List<User> findALL();

  /**
   * List roles.
   * 
   * @return the list
   */
  List<Role> listRoles();

  /**
   * Export users.
   * 
   * @param filterPredicate
   *          the filter predicate
   * @param paramObject
   *          the param object
   * @param httpServletResponse
   *          the http servlet response
   * @param attachmentFileName
   *          the attachment file name
   */
  void exportUsers(String filterPredicate, Map<String, Object> paramObject, HttpServletResponse httpServletResponse,
      String attachmentFileName);

  /**
   * Update.
   * 
   * @param user
   *          the user
   * @return the user
   */
  User update(User user);

  /**
   * Find all.
   * 
   * @param page
   *          the page
   * @param rows
   *          the rows
   * @param predicate
   *          the predicate
   * @param params
   *          the params
   * @return the page
   */
  Page<User> findALL(int page, int rows, String predicate, Map<String, Object> params);

  /**
   * Find by user name.
   * 
   * @param userName
   *          the user name
   * @return the user
   */
  User findByUserName(String userName);

  public void changePassword(String username, String currentPassword);

  public User findUserBy(String firstName, String lastName, String email, String phone);

  public boolean matchPassword(String username, String currentPassword, String newPassword);

  public User findByMlmAccountId(String mlmAccountId);

}
