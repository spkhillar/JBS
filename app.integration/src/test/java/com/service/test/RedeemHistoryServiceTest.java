package com.service.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;
import com.jpa.entities.enums.ModeOfRedemption;
import com.jpa.entities.enums.RedeemStatus;
import com.jpa.entities.enums.RedeemType;
import com.service.DepositIntimatorService;
import com.service.MlmUserCreditPointService;
import com.service.RedeemHistoryService;
import com.service.UserRegistrationService;
import com.service.UserService;

public class RedeemHistoryServiceTest extends BaseServiceTest {

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRegistrationService userRegistrationService;

  @Autowired
  private MlmUserCreditPointService mlmUserCreditPointService;

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  // @Test
  public void test1() {
    User user = userService.findByUserName("root");

    int sum = redeemHistoryService.sumOfPointBy(user);

    System.err.println("..First.." + sum);

    RedeemHistory redeemHistory =
        new RedeemHistory(user, 200, ModeOfRedemption.CASH, "none", RedeemStatus.NEW, new Date());
    redeemHistory = redeemHistoryService.save(redeemHistory);
    System.err.println("...ID..." + redeemHistory.getId());

    sum = redeemHistoryService.sumOfPointBy(user);
    System.err.println("..second.." + sum);

    redeemHistory = new RedeemHistory(user, 300, ModeOfRedemption.CASH, "none", RedeemStatus.NEW, new Date());
    redeemHistory.setRedeemType(RedeemType.COMMISSION_TRANSFER);
    redeemHistory = redeemHistoryService.save(redeemHistory);
    long revertId = redeemHistory.getId();
    System.err.println("...ID..." + redeemHistory.getId());

    sum = redeemHistoryService.sumOfPointBy(user);
    System.err.println("..third.." + sum);

    redeemHistory = redeemHistoryService.findById(revertId);
    redeemHistory.setStatus(RedeemStatus.REJECTED);
    redeemHistoryService.save(redeemHistory);

    sum = redeemHistoryService.sumOfPointBy(user);
    System.err.println("..4th.." + sum);
  }

  @Test
  public void test2() {
    User newUser = getUser("shiv3421");
    newUser = userRegistrationService.saveMlmUser(newUser, 1L, "shiv", null, null, null, 3l);
    User user = userService.findByUserName("root");
    redeemHistoryService.createCreditTransferRecord(BigDecimal.valueOf(600), BigDecimal.ZERO,
      newUser.getMlmAccountId(), "root");
    redeemHistoryService.createCreditTransferRecord(BigDecimal.ZERO, BigDecimal.valueOf(600),
      newUser.getMlmAccountId(), "root");
    redeemHistoryService.createCreditTransferRecord(BigDecimal.valueOf(200), BigDecimal.valueOf(600),
      newUser.getMlmAccountId(), "root");
    int total = mlmUserCreditPointService.findNumberOfOpenMLMCreditRecords(newUser);
    int balance = redeemHistoryService.sumOfPointBalanceBy(user);
    int commission = redeemHistoryService.sumOfPointBy(user);
    int depBalance = depositIntimatorService.getBalanceDeposit(newUser);
    System.err.println("..total mlm credpoints=" + total + ":balance=" + balance + ":commission:" + commission
        + ":depBalance=" + depBalance);
  }
}
