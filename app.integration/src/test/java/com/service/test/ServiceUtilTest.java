package com.service.test;

import org.junit.Test;

import com.service.util.ServiceUtil;

public class ServiceUtilTest {

  @Test
  public void mlmAccountIdTest() {
    for (int i = 0; i < 5; i++) {
      int id = ServiceUtil.mlmAccountId();
      System.err.println("..id-" + id);
    }
  }

}
