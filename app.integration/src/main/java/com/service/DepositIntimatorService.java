package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.DepositIntimator;

public interface DepositIntimatorService {

  public DepositIntimator save(DepositIntimator depositIntimator);

  public Page<DepositIntimator> findAll(int page, int rows, String sord, String sidx);

  public DepositIntimator findById(long depositorIntimatorId);

  public void approveOrRejectDepositIntimator(long depositorIntimatorId, int type, String memo);
}
