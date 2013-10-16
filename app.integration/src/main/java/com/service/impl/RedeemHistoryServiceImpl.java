package com.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.Payment;
import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.ModeOfRedemption;
import com.jpa.entities.enums.PaymentMode;
import com.jpa.entities.enums.RedeemStatus;
import com.jpa.entities.enums.RedeemType;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.RedeemHistoryDAO;
import com.service.DepositIntimatorService;
import com.service.MlmUserCreditPointService;
import com.service.PaymentService;
import com.service.RedeemHistoryService;
import com.service.UserService;
import com.service.util.ApplicationConstants;
import com.service.util.ServiceUtil;

@Service("redeemHistoryService")
public class RedeemHistoryServiceImpl implements RedeemHistoryService {

  private static final Logger logger = Logger.getLogger(RedeemHistoryServiceImpl.class);

  @Autowired
  private RedeemHistoryDAO redeemHistoryDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private UserService userService;

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private MlmUserCreditPointService mlmUserCreditPointService;

  @Override
  @Transactional
  public RedeemHistory save(final RedeemHistory redeemHistory) {
    return redeemHistoryDAO.save(redeemHistory);
  }

  @Override
  @Transactional(readOnly = true)
  public int sumOfPointBy(final User user) {
    String ejbql =
        "select sum(rh.points) from RedeemHistory rh where rh.user.id = :userId and (rh.status =:status1 or rh.status =:status2) "
            + "and (rh.redeemType =:redeemType1 or rh.redeemType =:redeemType2)";
    Map<String, Object> params = new HashMap<String, Object>(1);
    params.put("userId", user.getId());
    params.put("status1", RedeemStatus.NEW);
    params.put("status2", RedeemStatus.APPROVED);
    params.put("redeemType1", RedeemType.COMMISSION);
    params.put("redeemType2", RedeemType.COMMISSION_TRANSFER);
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RedeemHistory> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return redeemHistoryDAO.findByStatus(RedeemStatus.NEW, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public RedeemHistory findById(long id) {
    return redeemHistoryDAO.findOne(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RedeemHistory> findAllByUser(final User user, final int page, final int rows, final String sord,
      final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return redeemHistoryDAO.findByUser(user, pageable);
  }

  @Override
  @Transactional()
  public void approveOrRejectNotification(long id, int approval) {
    logger.info("approveOrRejectNotification with id=" + id + " and approval =" + approval);
    RedeemHistory redeemHistory = findById(id);
    if (approval == 1) {
      redeemHistory.setStatus(RedeemStatus.APPROVED);
    } else {
      redeemHistory.setStatus(RedeemStatus.REJECTED);
    }
    redeemHistory.setUpdatedAt(new Date());
    RedeemHistory savedRedeemHistory = save(redeemHistory);

    if (approval == 1) {
      logger.info("Creating Payment Record for Redeem History Id=" + id);
      Payment payment =
          new Payment(savedRedeemHistory, BigDecimal.valueOf(savedRedeemHistory.getPoints()), null, new Date());
      paymentService.save(payment);
    }
  }

  @Override
  @Transactional(readOnly = true)
  public int sumOfPointBalanceBy(final User user) {
    String ejbql =
        "select sum(rh.points) from RedeemHistory rh where rh.user.id = :userId and (rh.status =:status1 or rh.status =:status2) "
            + "and (rh.redeemType =:redeemType1)";
    Map<String, Object> params = new HashMap<String, Object>(1);
    params.put("userId", user.getId());
    params.put("status1", RedeemStatus.NEW);
    params.put("status2", RedeemStatus.APPROVED);
    params.put("redeemType1", RedeemType.DEPOSIT_TRANSFER);
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();
  }

  @Override
  @Transactional
  public void createCreditTransferRecord(final BigDecimal depositAmount, final BigDecimal commissionAmount,
      final String resellerId, final String currentUsername) {
    logger.info("createCreditTransferRecord starts ## ");
    logger.info("depositAmount=" + depositAmount + ".commissionAmount=" + commissionAmount + ".resellerId="
        + resellerId + ".currentUsername=" + currentUsername);
    User targetUser = userService.findByMlmAccountId(resellerId);
    User sourceUser = userService.findByUserName(currentUsername);
    BigDecimal total = depositAmount.add(commissionAmount);
    DepositIntimator depositIntimator =
        new DepositIntimator(0, targetUser, total, new Date(), PaymentMode.TRANSFER, DepositIntimatorStatus.APPROVED,
          new Date(), new Date());
    depositIntimator.setUserByReceiverUserId(sourceUser);
    depositIntimator.setDepositIntimatorType(DepositIntimatorType.MLM_CREDIT_POINT);
    depositIntimator.setMemo(ApplicationConstants.CREDIT_TRANSFER);
    depositIntimator = depositIntimatorService.save(depositIntimator);
    mlmUserCreditPointService.save(depositIntimator);
    RedeemHistory redeemHistory = null;
    if (depositAmount.intValue() > 0) {
      logger.info("creating DEPOSIT_TRANSFER RedeemHistory ## ");
      redeemHistory =
          new RedeemHistory(sourceUser, depositAmount.intValue(), ModeOfRedemption.CASH,
            ApplicationConstants.CREDIT_TRANSFER, RedeemStatus.APPROVED, new Date());
      redeemHistory.setRedeemType(RedeemType.DEPOSIT_TRANSFER);
      save(redeemHistory);
    }
    if (commissionAmount.intValue() > 0) {
      logger.info("creating COMMISSION_TRANSFER RedeemHistory ## ");
      redeemHistory =
          new RedeemHistory(sourceUser, commissionAmount.intValue(), ModeOfRedemption.CASH,
            ApplicationConstants.CREDIT_TRANSFER, RedeemStatus.APPROVED, new Date());
      redeemHistory.setRedeemType(RedeemType.COMMISSION_TRANSFER);
      save(redeemHistory);
    }

    logger.info("createCreditTransferRecord ends ## ");
  }
}
