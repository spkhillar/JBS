package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.SystemConfiguration;

public interface SystemConfigurationService {

  public SystemConfiguration findByKey(String key);

  public SystemConfiguration findByKeyAndValue(String key, String value);

  // public SystemConfiguration save(String key, String value);

  public Page<SystemConfiguration> findAll(int page, int rows, String sord, String sidx);

  public SystemConfiguration update(SystemConfiguration systemConfiguration);

  public SystemConfiguration find(Long id);

}
