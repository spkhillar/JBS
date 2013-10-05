package com.service;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;

public interface RedeemHistoryService {

  public RedeemHistory save(RedeemHistory redeemHistory);

  public int sumOfPointBy(User user);

}
