package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;

public interface DepositIntimatorService {

  public DepositIntimator save(DepositIntimator depositIntimator);

  public Page<DepositIntimator> findAll(int page, int rows, String sord, String sidx,
      DepositIntimatorStatus depositIntimatorStatus, User user);

  public DepositIntimator findById(long depositorIntimatorId);

  public void approveOrRejectDepositIntimator(long depositorIntimatorId, int type, String memo);

  public int calculateTotalSumForDepositIntimatorUser(User user);

  public int getBalanceDeposit(User user);

  public Page<DepositIntimator> findAllCreditTransferBy(User user, int page, int rows, String sord, String sidx);
}
