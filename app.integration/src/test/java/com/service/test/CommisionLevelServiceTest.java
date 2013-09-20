package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.CommisionLevelService;

public class CommisionLevelServiceTest extends BaseServiceTest {

  @Autowired
  private CommisionLevelService commisionLevelService;

  @Test
  public void testFindCommision() {
    commisionLevelService.findByLevel(1);
  }
}
