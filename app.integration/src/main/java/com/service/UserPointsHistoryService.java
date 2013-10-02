package com.service;

import com.jpa.entities.User;
import com.jpa.entities.UserPointsHistory;

public interface UserPointsHistoryService {

  public UserPointsHistory save(UserPointsHistory userPointsHistory);

  public int getLastUserPointTotal(User user);

}
