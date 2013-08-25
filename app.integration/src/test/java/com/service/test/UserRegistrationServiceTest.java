package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.UserRegistrationService;

public class UserRegistrationServiceTest extends BaseServiceTest {

  @Autowired
  private UserRegistrationService userRegistrationService;

  @Test
  public void test() {
    userRegistrationService.getJobsFunctionalArea();
  }

}
