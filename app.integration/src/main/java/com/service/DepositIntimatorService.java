package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.DepositIntimator;

public interface DepositIntimatorService {

  public void save(DepositIntimator depositIntimator);

  public Page<DepositIntimator> findAll(int page, int rows, String sord, String sidx);
}
