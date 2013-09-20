package com.service;

import com.jpa.entities.User;
import com.jpa.entities.enums.UserPosition;

public interface UserGroupService {

  public void addToGroup(User currentUser, String parentMlmId, UserPosition position);

  public void findChild(String username);
}
