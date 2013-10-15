package com.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;
import com.jpa.entities.enums.ModeOfRedemption;
import com.jpa.entities.enums.RedeemStatus;
import com.jpa.entities.enums.RedeemType;
import com.service.RedeemHistoryService;
import com.service.UserService;

public class RedeemHistoryServiceTest extends BaseServiceTest {

  @Autowired
  private RedeemHistoryService redeemHistoryService;

  @Autowired
  private UserService userService;

  @Test
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
}
