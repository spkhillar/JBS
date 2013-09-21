/**
 * 
 */
package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.entities.SystemConfiguration;
import com.jpa.repositories.SystemConfigurationDAO;
import com.service.SystemConfigurationService;
import com.service.util.ServiceUtil;

/**
 * @author shivprasak
 * 
 */
@Service("systemConfigurationService")
public class SystemConfigurationServiceImpl implements SystemConfigurationService {

  @Autowired
  private SystemConfigurationDAO systemConfigurationDAO;

  /**
   * 
   * 
   * @see com.service.SystemConfigurationService#findByKey(java.lang.String)
   */
  @Override
  public SystemConfiguration findByKey(final String key) {
    return systemConfigurationDAO.findByKey(key);
  }

  /**
   * 
   * 
   * @see com.service.SystemConfigurationService#findByKeyAndValue(java.lang.String,
   *      java.lang.String)
   */
  @Override
  public SystemConfiguration findByKeyAndValue(final String key, final String value) {
    return systemConfigurationDAO.findByKeyAndValue(key, value);
  }

  /*
   * @Override public SystemConfiguration save(String key, String value) {
   * SystemConfiguration systemConfiguration = new SystemConfiguration(key,
   * value, new Date()); return
   * systemConfigurationDAO.save(systemConfiguration); }
   */

  @Override
  public SystemConfiguration update(final SystemConfiguration systemConfiguration) {
    SystemConfiguration dbConfiguration = systemConfigurationDAO.findOne(systemConfiguration.getId());
    dbConfiguration.setValue(systemConfiguration.getValue());
    dbConfiguration.setUpdatedAt(new Date());
    return systemConfigurationDAO.save(dbConfiguration);
  }


  @Override
  public Page<SystemConfiguration> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return systemConfigurationDAO.findAll(pageable);
  }


}
