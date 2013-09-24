package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.enums.DepositIntimatorStatus;
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
  @Transactional(readOnly = true)
  public Page<DepositIntimator> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return depositIntimatorDAO.findByStatus(DepositIntimatorStatus.NEW, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public DepositIntimator findById(final long depositorIntimatorId) {
    return depositIntimatorDAO.findOne(depositorIntimatorId);
  }

  @Override
  @Transactional
  public void approveOrRejectDepositIntimator(long depositorIntimatorId, int type) {
    DepositIntimator depositIntimator = this.findById(depositorIntimatorId);
    if (type == 1) {
      depositIntimator.setStatus(DepositIntimatorStatus.APPROVED);
    } else if (type == 0) {
      depositIntimator.setStatus(DepositIntimatorStatus.REJECTED);
    } else {
      throw new UnsupportedOperationException("Type " + type + " is not an identified operation");
    }
    depositIntimator.setUpdatedAt(new Date());
    depositIntimatorDAO.save(depositIntimator);
  }

}
