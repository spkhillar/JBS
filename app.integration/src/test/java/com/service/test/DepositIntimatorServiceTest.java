package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.service.DepositIntimatorService;
import com.service.UserService;

public class DepositIntimatorServiceTest extends BaseServiceTest {

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Autowired
  private UserService userService;

  @Test
  public void testFindAll() {
    User user = userService.findByUserName("root");
    depositIntimatorService.calculateTotalSumForDepositIntimatorUser(user);
  }
}
