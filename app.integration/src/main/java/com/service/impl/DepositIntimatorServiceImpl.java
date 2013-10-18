package com.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.repositories.DepositIntimatorDAO;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.service.DepositIntimatorService;
import com.service.MlmUserCreditPointService;
import com.service.RedeemHistoryService;
import com.service.util.ApplicationConstants;
import com.service.util.ServiceUtil;

@Service("depositIntimatorService")
public class DepositIntimatorServiceImpl implements DepositIntimatorService {

  @Autowired
  private DepositIntimatorDAO depositIntimatorDAO;

  @Autowired
  private MlmUserCreditPointService mlmUserCreditPointService;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  @Override
  @Transactional
  public DepositIntimator save(final DepositIntimator depositIntimator) {
    return depositIntimatorDAO.save(depositIntimator);

  }

  @Override
  @Transactional(readOnly = true)
  public Page<DepositIntimator> findAll(final int page, final int rows, final String sord, final String sidx,
      DepositIntimatorStatus depositIntimatorStatus, User user) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    if (depositIntimatorStatus != null) {
      return depositIntimatorDAO.findByStatus(depositIntimatorStatus, pageable);
    }
    List<DepositIntimatorStatus> deposIntimatorStatusList = new ArrayList<DepositIntimatorStatus>();
    deposIntimatorStatusList.add(DepositIntimatorStatus.NEW);
    deposIntimatorStatusList.add(DepositIntimatorStatus.APPROVED);
    deposIntimatorStatusList.add(DepositIntimatorStatus.REJECTED);
    return depositIntimatorDAO.findByUserByUserIdAndStatusIn(user, deposIntimatorStatusList, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public DepositIntimator findById(final long depositorIntimatorId) {
    return depositIntimatorDAO.findOne(depositorIntimatorId);
  }

  @Override
  @Transactional
  public void approveOrRejectDepositIntimator(long depositorIntimatorId, int type, String memo) {
    DepositIntimator depositIntimator = this.findById(depositorIntimatorId);
    if (type == 1) {
      depositIntimator.setStatus(DepositIntimatorStatus.APPROVED);
    } else if (type == 0) {
      depositIntimator.setStatus(DepositIntimatorStatus.REJECTED);
    } else {
      throw new UnsupportedOperationException("Type " + type + " is not an identified operation");
    }
    depositIntimator.setUpdatedAt(new Date());
    depositIntimator.setMemo(memo);
    DepositIntimator savedDepositIntimator = this.save(depositIntimator);
    if (type == 1) {
      mlmUserCreditPointService.save(savedDepositIntimator);
    }
  }

  @Transactional(readOnly = true)
  @Override
  public int calculateTotalSumForDepositIntimatorUser(User user) {
    String ejbql =
        "select sum(di.amountDeposited) from DepositIntimator di where di.userByUserId.id=:userId and "
            + "(di.status =:status1 or di.status =:status2)";
    Map<String, Object> params = new HashMap<String, Object>(1);
    params.put("userId", user.getId());
    params.put("status1", DepositIntimatorStatus.NEW);
    params.put("status2", DepositIntimatorStatus.APPROVED);
    List<BigDecimal> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();
  }

  @Transactional(readOnly = true)
  @Override
  public int getBalanceDeposit(User user) {
    int total = calculateTotalSumForDepositIntimatorUser(user);
    int mlmUserCredPoints = mlmUserCreditPointService.findNumberOfOpenMLMCreditRecords(user);
    int redeemed = redeemHistoryService.sumOfPointBalanceBy(user);
    return total - mlmUserCredPoints - redeemed;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<DepositIntimator> findAllCreditTransferBy(User user, final int page, final int rows, final String sord,
      final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return depositIntimatorDAO.findByUserByReceiverUserIdAndMemo(user, ApplicationConstants.CREDIT_TRANSFER, pageable);
  }
}
