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
import com.service.MlmUserCreditPointService;
import com.service.SystemConfigurationService;
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

  @Override
  @Transactional
  public void save(final DepositIntimator depositIntimator) {

    if (DepositIntimatorType.MLM_CREDIT_POINT.equals(depositIntimator.getDepositIntimatorType())) {
      createCreditPointsForMlm(depositIntimator);
    } else {
      throw new UnsupportedOperationException("Only Mlm type is allowed as of now");
    }

  }

  @Override
  @Transactional(readOnly = true)
  public long getUserPointCount(final User user) {
    String query =
        "select count(*) from MlmUserCreditPoint mucp where mucp.mlmUserCreditPointStatus =:mlmUserCreditPointStatus and "
            + "mucp.user =:user and mucp.depositIntimator.status =:status";

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("mlmUserCreditPointStatus", MlmUserCreditPointStatus.OPEN);
    params.put("user", user);
    params.put("status", DepositIntimatorStatus.APPROVED);

    return genericQueryExecutorDAO.findCount(query, params);
  }

  @Override
  @Transactional(readOnly = true)
  public List<MlmUserCreditPoint> listMlmUserCreditPoint(final User user, final MlmUserCreditPointStatus mlmUserCreditPointStatus,
    final DepositIntimatorStatus depositIntimatorStatus) {
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
  public void updateStatus(final MlmUserCreditPoint mlmUserCreditPoint, final MlmUserCreditPointStatus mlmUserCreditPointStatus) {
    MlmUserCreditPoint savedMlmUserCreditPoint = mlmUserCreditPointDAO.findOne(mlmUserCreditPoint.getId());
    savedMlmUserCreditPoint.setMlmUserCreditPointStatus(mlmUserCreditPointStatus);
    mlmUserCreditPointDAO.save(savedMlmUserCreditPoint);
  }

  private void createCreditPointsForMlm(final DepositIntimator depositIntimator) {
    SystemConfiguration systemConfiguration =
        systemConfigurationService.findByKey(ApplicationConstants.SUBSCRIPTION_BASE_PRICE);
    int subscriptionBasePrice = Integer.valueOf(systemConfiguration.getValue());

    int numOfRecords = depositIntimator.getAmountDeposited().intValue() / subscriptionBasePrice;
    logger.debug("...creating " + numOfRecords + "mlm credit points ");
    if (numOfRecords == 2) {
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      MlmUserCreditPoint mlmUserCreditPoint2 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint2);
    } else {
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, subscriptionBasePrice);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
    }
  }

  private MlmUserCreditPoint mlmUserCreditPointRecord(final DepositIntimator depositIntimator, final int points) {
    MlmUserCreditPoint mlmUserCreditPoint =
        new MlmUserCreditPoint(points, MlmUserCreditPointStatus.OPEN, depositIntimator.getUserByUserId(),
          depositIntimator, null, new Date());
    return mlmUserCreditPoint;
  }


}
