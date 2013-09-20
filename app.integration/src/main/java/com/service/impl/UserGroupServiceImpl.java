package com.service.impl;

import java.util.Date;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entities.User;
import com.jpa.entities.UserGroups;
import com.jpa.entities.enums.UserPosition;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.UserDAO;
import com.jpa.repositories.UserGroupsDAO;
import com.service.UserGroupService;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {

  @Autowired
  private UserGroupsDAO userGroupsDAO;

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Override
  public void addToGroup(User currentUser, String parentMlmId, UserPosition position) {
    User parentUser = null;
    if (StringUtils.isBlank(parentMlmId)) {
      parentUser = userDAO.findByUserName("root");
    } else {
      parentUser = userDAO.findByMlmAccountId(parentMlmId);
    }
    UserGroups parentUserGroups = userGroupsDAO.findByUserByGroupId(parentUser);
    int level = parentUserGroups.getLevel() + 1;
    UserGroups userGroups = new UserGroups(currentUser, parentUser, level, position, new Date());
    parentUser.getUserGroupsesForParentGroupId().add(userGroups);
    currentUser.getUserGroupsesForGroupId().add(userGroups);
    userGroupsDAO.save(userGroups);
  }

  @Override
  public void findChild(String username) {
    User grp = userDAO.findByUserName(username);
    if (grp != null) {
      Set<UserGroups> groups = grp.getUserGroupsesForParentGroupId();
      if (CollectionUtils.isNotEmpty(groups)) {
        for (UserGroups groups2 : groups) {
          if (groups2.getUserByGroupId() != null) {
            System.err.println("...child groups2..." + groups2.getUserByGroupId().getUserName());
            findChild(groups2.getUserByGroupId().getUserName());
          }
        }
      }
    }
  }
}
