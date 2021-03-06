package com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jpa.entities.User;
import com.jpa.entities.UserPointsHistory;

public interface UserPointsHistoryService {

  public UserPointsHistory save(UserPointsHistory userPointsHistory);

  public int getLastUserPointTotal(User user);

  public Page<UserPointsHistory> findUserPointByUserName(User user, int page, int rows, String sord, String sidx);

  public Page<UserPointsHistory> findSystemIncentivePoint(int page, int rows, String sord, String sidx);

  public int getUserTotalCommsionPoint(User user);

  public Page<UserPointsHistory> findUserPointByUserName(User user, Pageable page);

}
