package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;

public interface RedeemHistoryService {

  public RedeemHistory save(RedeemHistory redeemHistory);

  public int sumOfPointBy(User user);

  public Page<RedeemHistory> findAll(int page, int rows, String sord, String sidx);

  public RedeemHistory findById(long id);

  public Page<RedeemHistory> findAllByUser(User user, int page, int rows, String sord, String sidx);

  public void approveOrRejectNotification(long id, int approval);

  public int sumOfPointBalanceBy(User user);

}
