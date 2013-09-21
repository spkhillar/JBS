package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.SystemConfiguration;
import com.service.SystemConfigurationService;

public class SystemConfigurationServiceTest extends BaseServiceTest {

  @Autowired
  private SystemConfigurationService systemConfigurationService;

  @Test
  public void testConfig() {
    SystemConfiguration systemConfiguration = systemConfigurationService.findByKey("root-mlm-1");
    System.err.println("..systemConfiguration.." + systemConfiguration);
    systemConfiguration.setValue("hhehehe");
    // SystemConfiguration newConfiguration =
    // systemConfigurationService.save("test", "test");
    SystemConfiguration updatedSystemConfiguration = systemConfigurationService.update(systemConfiguration);
    System.err.println("..upatedd systemConfiguration.." + updatedSystemConfiguration);

  }
}
