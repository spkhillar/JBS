package com.service;

import java.util.Date;
import java.util.List;

import com.jpa.entities.User;
import com.jpa.entities.enums.UserPosition;

public interface UserGroupService {

  public void addToGroup(User currentUser, String parentMlmId, UserPosition position);

  public void findChild(String username);

  public User findMlmAdminUser(User parentUser, UserPosition userPosition);

  public List<Long> findUserGroupsBy(Date startDate, Date endDate, boolean commisionPayed);

  public void allocateCommision(Date startDate, Date endDate);
}
