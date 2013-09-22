package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.entities.DepositIntimator;
import com.jpa.repositories.DepositIntimatorDAO;
import com.service.DepositIntimatorService;
import com.service.util.ServiceUtil;

@Service("depositIntimatorService")
public class DepositIntimatorServiceImpl implements DepositIntimatorService {

  @Autowired
  private DepositIntimatorDAO depositIntimatorDAO;

  @Override
  public void save(final DepositIntimator depositIntimator) {

    depositIntimatorDAO.save(depositIntimator);

  }

  @Override
  public Page<DepositIntimator> findAll(final int page,  final int rows,  final String sord,  final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return depositIntimatorDAO.findAll(pageable);
  }

  @Override
  public DepositIntimator findById(final long depositorIntimatorId) {
    return depositIntimatorDAO.findOne(depositorIntimatorId);
  }

}
