package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.DepositIntimatorService;

public class DepositIntimatorServiceTest extends BaseServiceTest {

  @Autowired
  private DepositIntimatorService depositIntimatorService;

  @Test
  public void testFindAll() {
    depositIntimatorService.findAll(1, 10, "asc", "id");
  }
}
