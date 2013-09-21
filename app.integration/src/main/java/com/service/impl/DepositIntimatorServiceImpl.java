package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entities.DepositIntimator;
import com.jpa.repositories.DepositIntimatorDAO;
import com.service.DepositIntimatorService;

@Service("depositIntimatorService")
public class DepositIntimatorServiceImpl implements DepositIntimatorService {

  @Autowired
  private DepositIntimatorDAO depositIntimatorDAO;

  @Override
  public void save(final DepositIntimator depositIntimator) {

    depositIntimatorDAO.save(depositIntimator);

  }

}
