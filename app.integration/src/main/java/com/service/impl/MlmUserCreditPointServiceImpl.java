package com.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.MlmUserCreditPointStatus;
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

  @Override
  @Transactional
  public void save(DepositIntimator depositIntimator) {

    if (DepositIntimatorType.MLM_CREDIT_POINT.equals(depositIntimator.getDepositIntimatorType())) {
      createCreditPointsForMlm(depositIntimator);
    } else {
      throw new UnsupportedOperationException("Only Mlm type is allowed as of now");
    }

  }

  private void createCreditPointsForMlm(DepositIntimator depositIntimator) {
    SystemConfiguration systemConfiguration =
        systemConfigurationService.findByKey(ApplicationConstants.SUBSCRIPTION_BASE_PRICE);
    int subscriptionBasePrice = Integer.valueOf(systemConfiguration.getValue());

    int numOfRecords = depositIntimator.getAmountDeposited().intValue() / subscriptionBasePrice;
    logger.debug("...creating " + numOfRecords + "mlm credit points ");
    if (numOfRecords == 2) {
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, 600);
      MlmUserCreditPoint mlmUserCreditPoint2 = mlmUserCreditPointRecord(depositIntimator, 600);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint2);
    } else {
      MlmUserCreditPoint mlmUserCreditPoint1 = mlmUserCreditPointRecord(depositIntimator, 600);
      mlmUserCreditPointDAO.save(mlmUserCreditPoint1);
    }
  }

  private MlmUserCreditPoint mlmUserCreditPointRecord(DepositIntimator depositIntimator, int points) {
    MlmUserCreditPoint mlmUserCreditPoint =
        new MlmUserCreditPoint(points, MlmUserCreditPointStatus.OPEN, depositIntimator.getUserByUserId(),
          depositIntimator, null, new Date());
    return mlmUserCreditPoint;
  }

}
