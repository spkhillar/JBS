package com.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.MlmUserCreditPointStatus;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.MlmUserCreditPointDAO;
import com.service.DepositIntimatorService;
import com.service.MlmUserCreditPointService;
import com.service.SystemConfigurationService;
import com.service.UserGroupService;
import com.service.util.ApplicationConstants;

@Service("mlmUserCreditPointService")
public class MlmUserCreditPointServiceImpl implements MlmUserCreditPointService {

  private static final Logger logger = Logger.getLogger(MlmUserCreditPointServiceImpl.class);

  @Autowired
  private SystemConfigurationService systemConfigurationService;

  @Autowired
  private MlmUserCreditPointDAO mlmUserCreditPointDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private UserGroupService userGroupService;

  @Override
  @Transactional
  public void save(final DepositIntimator depositIntimator) {
    if (DepositIntimatorType.MLM_CREDIT_POINT.equals(depositIntimator.getDepositIntimatorType())) {
      boolean hasBinary = userGroupService.checkIfUserHasBinary(depositIntimator.getUserByUserId());
      if (!hasBinary) {
        createCreditPointsForMlm(depositIntimator);
      } else {
        logger.debug("Not creating MlmUserCreditPoint");
      }
    } else {
      throw new UnsupportedOperationException("Only Mlm type is allowed as of now");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public long getUserPointCount(final User user) {
    long count = 0;
    int numOfChilds = user.getUserGroupsesForParentGroupId().size();
    if (numOfChilds < 2) {
      String query =
          "select count(*) from MlmUserCreditPoint mucp where mucp.mlmUserCreditPointStatus =:mlmUserCreditPointStatus and "
              + "mucp.user =:user and mucp.depositIntimator.status =:status";
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("mlmUserCreditPointStatus", MlmUserCreditPointStatus.OPEN);
      params.put("user", user);
      params.put("status", DepositIntimatorStatus.APPROVED);
      count = genericQueryExecutorDAO.findCount(query, params);
      if (count >= 2 && numOfChilds == 0) {
        count = 2;
      } else if (count >= 2 && numOfChilds == 1) {
        count = 1;
      } else if (count == 1 && numOfChilds == 0) {
        count = 1;
      }
    }
    return count;
  }

  @Override
  @Transactional(readOnly = true)
  public List<MlmUserCreditPoint> listMlmUserCreditPoint(final User user,
      final MlmUserCreditPointStatus mlmUserCreditPointStatus, final DepositIntimatorStatus depositIntimatorStatus) {
    String query =
        "from MlmUserCreditPoint mucp where mucp.mlmUserCreditPointStatus =:mlmUserCreditPointStatus and "
            + "mucp.user =:user and mucp.depositIntimator.status =:status";

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("mlmUserCreditPointStatus", mlmUserCreditPointStatus);
    params.put("user", user);
    params.put("status", depositIntimatorStatus);

    return genericQueryExecutorDAO.executeQuery(query, MlmUserCreditPoint.class, params);
  }

  @Override
  @Transactional(readOnly = true)
  public List<MlmUserCreditPoint> findByMlmUserCreditPointStatus(final MlmUserCreditPointStatus mlmUserCreditPointStatus) {
    return mlmUserCreditPointDAO.findByMlmUserCreditPointStatus(mlmUserCreditPointStatus);
  }

  @Override
  @Transactional
  public void updateStatus(final MlmUserCreditPoint mlmUserCreditPoint,
      final MlmUserCreditPointStatus mlmUserCreditPointStatus) {
    MlmUserCreditPoint savedMlmUserCreditPoint = mlmUserCreditPointDAO.findOne(mlmUserCreditPoint.getId());
    savedMlmUserCreditPoint.setMlmUserCreditPointStatus(mlmUserCreditPointStatus);
    mlmUserCreditPointDAO.save(savedMlmUserCreditPoint);
  }

  @Override
  @Transactional(readOnly = true)
  public int findNumberOfOpenMLMCreditRecords(User user) {
    String ejbql =
        "select sum(mcp.points) from MlmUserCreditPoint mcp where mcp.user.id=:userId and (mcp.mlmUserCreditPointStatus =:status1 or mcp.mlmUserCreditPointStatus =:status2)";
    Map<String, Object> params = new HashMap<String, Object>(2);
    params.put("userId", user.getId());
    params.put("status1", MlmUserCreditPointStatus.OPEN);
    params.put("status2", MlmUserCreditPointStatus.CLOSED);
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();

  }

  private void createCreditPointsForMlm(final DepositIntimator depositIntimator) {
    SystemConfiguration systemConfiguration =
        systemConfigurationService.findByKey(ApplicationConstants.SUBSCRIPTION_BASE_PRICE);
    int subscriptionBasePrice = Integer.valueOf(systemConfiguration.getValue());
    int totalSum = depositIntimatorService.calculateTotalSumForDepositIntimatorUser(depositIntimator.getUserByUserId());
    int numOfRecords = totalSum / subscriptionBasePrice;
    int numberOfOpenRecords =
        findNumberOfOpenMLMCreditRecords(depositIntimator.getUserByUserId(), MlmUserCreditPointStatus.OPEN);
    int numberOfCloseRecords =
        findNumberOfOpenMLMCreditRecords(depositIntimator.getUserByUserId(), MlmUserCreditPointStatus.CLOSED);
    logger.debug("...Division count=" + numOfRecords + " mlm credit points. numberOfOpenRecords=" + numberOfOpenRecords
        + ".numberOfCloseRecords=" + numberOfCloseRecords);
    if (numOfRecords >= 2 && numberOfOpenRecords == 1 && numberOfCloseRecords == 0) {
      logger.debug("...creating " + 1 + " mlm credit points ");
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
    } else if (numOfRecords >= 2 && numberOfOpenRecords == 0 && numberOfCloseRecords == 1) {
      logger.debug("...creating " + 1 + " mlm credit points ");
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
    } else if (numOfRecords >= 2 && numberOfOpenRecords == 0) {
      logger.debug("...creating " + 2 + " mlm credit points ");
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      MlmUserCreditPoint mlmUserCreditPoint2 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint2);
    } else if (numOfRecords >= 1 && numberOfOpenRecords == 0) {
      logger.debug("...creating " + 1 + " mlm credit points ");
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
    } else {
      logger.debug("Cannot create MLM User Credit Points as Both the nodes are complete");
    }
  }

  private int findNumberOfOpenMLMCreditRecords(User user, MlmUserCreditPointStatus mlmUserCreditPointStatus) {
    String ejbql =
        "select count(*) from MlmUserCreditPoint mcp where mcp.user.id=:userId and mcp.mlmUserCreditPointStatus =:status";
    Map<String, Object> params = new HashMap<String, Object>(2);
    params.put("userId", user.getId());
    params.put("status", mlmUserCreditPointStatus);
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();

  }

  private MlmUserCreditPoint mlmUserCreditPointRecord(final DepositIntimator depositIntimator, final int points) {
    MlmUserCreditPoint mlmUserCreditPoint =
        new MlmUserCreditPoint(points, MlmUserCreditPointStatus.OPEN, depositIntimator.getUserByUserId(),
          depositIntimator, null, new Date());
    return mlmUserCreditPoint;
  }

}
