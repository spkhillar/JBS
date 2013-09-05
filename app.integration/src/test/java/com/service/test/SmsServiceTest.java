package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.SmsService;

public class SmsServiceTest extends BaseServiceTest {

  @Autowired
  private SmsService smsService;

  @Test
  public void testSms() {
    smsService.sendSms(null, null);
  }

}
