/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.Role;
import com.jpa.entities.User;
import com.web.form.UserRegistrationForm;
import com.web.rest.RestResponse;
import com.web.util.DomainObjectMapper;
import com.web.util.JqGridResponse;

/**
 * The Class UserController.
 * 
 * @author
 */
@RequestMapping(value = "/user")
@Controller
public class UserController extends AbstractJqGridFilterController {

  /** The excluded props in filter. */
  private final String[] excludedPropsInFilter = new String[] { "roleId" };

  /** The Constant excludedPropQueryMapping. */
  private static final Map<String, String> excludedPropQueryMapping = new HashMap<String, String>();

  /** The Constant excludedPropOrderMapping. */
  private static final Map<String, String> excludedPropOrderMapping = new HashMap<String, String>();
  static {
    excludedPropQueryMapping.put("roleId", "userRole.role.id");
    excludedPropOrderMapping.put("roleId", "userRole.role.name");
  }

  /**
   * Gets the users page.
   * 
   * @return the users page
   */
  @RequestMapping(value = "/list")
  public String getUsersPage(final Model model) {
    return "admin.users";
  }

  /**
   * Records.
   * 
   * @param search
   *          the search
   * @param filters
   *          the filters
   * @param page
   *          the page
   * @param rows
   *          the rows
   * @param sidx
   *          the sidx
   * @param sord
   *          the sord
   * @return the jq grid response
   */
  @RequestMapping(value = "/records", produces = "application/json")
  public @ResponseBody
  JqGridResponse<User> records(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {
    Page<User> users = null;
    if (search == true) {
      Map<String, Object> paramObject = new LinkedHashMap<String, Object>();
      String filterPredicate = getFilteredRecords(filters, sord, sidx, paramObject, User.class);
      users = userService.findALL(page, rows, filterPredicate, paramObject);
    } else {
      users = userService.findALL(page, rows, sord, sidx);
    }
    List<Object> list = DomainObjectMapper.listEntities(users);
    JqGridResponse<User> response = new JqGridResponse<User>();
    response.setRows(list);
    response.setRecords(Long.valueOf(users.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(users.getTotalPages()).toString());
    response.setPage(Integer.valueOf(users.getNumber() + 1).toString());
    return response;
  }

  /**
   * Creates the.
   * 
   * @param user
   *          the user
   * @return the rest response
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public RestResponse create(User user) {
    user = userService.saveOrUpdate(user);
    String message = "Saved Successfully with Id" + user.getId();
    RestResponse response = new RestResponse(0, message);
    return response;
  }

  /**
   * Update.
   * 
   * @param user
   *          the user
   * @return the rest response
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public RestResponse update(final User user) {
    userService.update(user);
    String message = "User Updated Successfully";
    RestResponse response = new RestResponse(0, message);
    return response;
  }

  /**
   * Delete.
   * 
   * @param user
   *          the user
   * @return the rest response
   */
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  @ResponseBody
  public RestResponse delete(final User user) {
    userService.delete(user);
    String message = "User deleted Successfully";
    RestResponse response = new RestResponse(0, message);
    return response;
  }

  /**
   * Gets the roles.
   * 
   * @return the roles
   */
  @RequestMapping(value = "/roles")
  @ResponseBody
  public String getRoles() {
    List<Role> roleList = userService.listRoles();
    StringBuilder sb = new StringBuilder();
    for (Role role : roleList) {
      sb.append(role.getId()).append(":").append(role.getName()).append(";");
    }
    String roles = sb.substring(0, sb.length() - 1);
    return roles;
  }

  /**
   * Export.
   * 
   * @param search
   *          the search
   * @param filters
   *          the filters
   * @param page
   *          the page
   * @param rows
   *          the rows
   * @param sidx
   *          the sidx
   * @param sord
   *          the sord
   * @param httpServletResponse
   *          the http servlet response
   */
  @RequestMapping(value = "/export")
  public void export(@RequestParam("_search") final Boolean search,
      @RequestParam(value = "filters", required = false) final String filters,
      @RequestParam(value = "page", required = false) final Integer page,
      @RequestParam(value = "rows", required = false) final Integer rows,
      @RequestParam(value = "sidx", required = false) final String sidx,
      @RequestParam(value = "sord", required = false) final String sord, final HttpServletResponse httpServletResponse) {
    String filterPredicate = null;
    Map<String, Object> paramObject = null;
    if (search) {
      paramObject = new LinkedHashMap<String, Object>();
      filterPredicate = getFilteredRecords(filters, sord, sidx, paramObject, User.class);
    }
    userService.exportUsers(filterPredicate, paramObject, httpServletResponse, "users.xls");
  }

  /**
   * Check user name.
   * 
   * @param userName
   *          the user name
   * @return the boolean
   */
  @RequestMapping(value = "/checkUserName/{userName}")
  @ResponseBody
  public boolean checkUserName(@PathVariable final String userName) {
    User user = userService.findByUserName(userName);
    if (user != null) {
      return true;
    }
    return false;

  }

  /**
   * Gets the filter exclusion properties.
   * 
   * @return the filter exclusion properties
   * @see com.web.controller.AbstractJqGridFilterController#
   *      getFilterExclusionProperties()
   */
  @Override
  public String[] getFilterExclusionProperties() {
    return excludedPropsInFilter;
  }

  /**
   * Gets the filter excluded property query mapping.
   * 
   * @return the filter excluded property query mapping
   * @see com.web.controller.AbstractJqGridFilterController#
   *      getFilterExcludedPropertyQueryMapping()
   */
  @Override
  public Map<String, String> getFilterExcludedPropertyQueryMapping() {
    return excludedPropQueryMapping;
  }

  /**
   * Gets the filter excluded property order mapping.
   * 
   * @return the filter excluded property order mapping
   * @see com.web.controller.AbstractJqGridFilterController#
   *      getFilterExcludedPropertyOrderMapping()
   */
  @Override
  public Map<String, String> getFilterExcludedPropertyOrderMapping() {
    return excludedPropOrderMapping;
  }

  @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
  public String updateUser(@ModelAttribute("registration") final UserRegistrationForm userRegistrationForm,
      final ModelMap map, final HttpServletRequest request) throws IOException {
    byte[] resume = null;
    String fileName = null;
    MultipartFile multipartFile = userRegistrationForm.getResume();
    if (multipartFile != null) {
      resume = multipartFile.getBytes();
      fileName = multipartFile.getOriginalFilename();
    }
    userRegistrationService.updateUser(userRegistrationForm.getUser(),
      userRegistrationForm.getSecurityQuestion(), userRegistrationForm.getSecurityAnswer(), resume, fileName,
      userRegistrationForm.getDegree());
    return getHomePage(map);
  }

  @RequestMapping(value = "/resellers", produces = "application/json")
  public @ResponseBody
  JqGridResponse<User> resellers(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {

    return fetchUserListByRole(search, filters, page, rows, sidx, sord, 3);
  }

  @RequestMapping(value = "/normal", produces = "application/json")
  public @ResponseBody
  JqGridResponse<User> normalUsers(@RequestParam("_search") final Boolean search,
    @RequestParam(value = "filters", required = false) final String filters,
    @RequestParam(value = "page", required = false) final Integer page,
    @RequestParam(value = "rows", required = false) final Integer rows,
    @RequestParam(value = "sidx", required = false) final String sidx,
    @RequestParam(value = "sord", required = false) final String sord) {

    return fetchUserListByRole(search, filters, page, rows, sidx, sord, 2);
  }

  private JqGridResponse<User> fetchUserListByRole(final Boolean search, final String filters, final Integer page,
    final Integer rows, final String sidx, final String sord, final long roleId) {
    Page<User> users = null;
    /*
     * if (search == true) { users = userService.findALL(page, rows,
     * filterPredicate, paramObject); } else { users = userService.findALL(page,
     * rows, sord, sidx); }
     */
    users = userService.findByRole(roleId, page, rows, sord, sidx);
    List<Object> list = DomainObjectMapper.listEntities(users);
    JqGridResponse<User> response = new JqGridResponse<User>();
    response.setRows(list);
    response.setRecords(Long.valueOf(users.getTotalElements()).toString());
    response.setTotal(Integer.valueOf(users.getTotalPages()).toString());
    response.setPage(Integer.valueOf(users.getNumber() + 1).toString());
    return response;
  }

  @RequestMapping(value = "/reseller/{resellerId}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public User getUserByMlmId(@PathVariable final String resellerId) {
    User user = userService.findByMlmAccountId(resellerId);
    return user;

  }

}
