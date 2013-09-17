package com.jpa.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.MlmUserCreditPointStatus;
import com.jpa.entities.enums.PaymentMode;
import com.jpa.repositories.DepositIntimatorDAO;
import com.jpa.repositories.MlmUserCreditPointDAO;
import com.jpa.repositories.UserDAO;

public class MlmUserCreditPointDAOTest extends BaseTest {

  @Autowired
  private MlmUserCreditPointDAO mlmUserCreditPointDAO;

  @Autowired
  private DepositIntimatorDAO depositIntimatorDAO;

  @Autowired
  private UserDAO userDAO;

  @Test
  public void testCreditPoint() {
    User user = userDAO.findOne(1L);

    DepositIntimator depositIntimator = new DepositIntimator();
    depositIntimator.setAmountDeposited(BigDecimal.valueOf(600));
    depositIntimator.setModeOfPayment(PaymentMode.MANUAL);
    depositIntimator.setStatus(DepositIntimatorStatus.NEW);
    depositIntimator.setDepositIntimatorType(DepositIntimatorType.NEW_SUBSCRIPTION);
    depositIntimator.setTransactedDate(new Date());
    depositIntimator.setUpdatedAt(new Date());
    depositIntimator.setUserByUserId(user);
    DepositIntimator savedDepositIntimator = depositIntimatorDAO.save(depositIntimator);

    MlmUserCreditPoint mlmUserCreditPoint = new MlmUserCreditPoint();
    mlmUserCreditPoint.setDepositIntimator(savedDepositIntimator);
    mlmUserCreditPoint.setMlmUserCreditPointStatus(MlmUserCreditPointStatus.OPEN);
    mlmUserCreditPoint.setPoints(600);
    mlmUserCreditPoint.setUpdatedAt(new Date());
    mlmUserCreditPoint.setUser(user);
    mlmUserCreditPointDAO.save(mlmUserCreditPoint);

    mlmUserCreditPointDAO.findAll();
  }
}
