package com.service;

import com.jpa.entities.SystemConfiguration;

public interface SystemConfigurationService {

  public SystemConfiguration findByKey(String key);

  public SystemConfiguration findByKeyAndValue(String key, String value);

  // public SystemConfiguration save(String key, String value);

  SystemConfiguration update(SystemConfiguration systemConfiguration);

}
