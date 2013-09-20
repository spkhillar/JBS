package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CommisionLevel;
import com.jpa.repositories.CommisionLevelDAO;
import com.service.CommisionLevelService;
import com.service.util.ServiceUtil;

@Service("commisionLevelService")
public class CommisionLevelServiceImpl implements CommisionLevelService {

  @Autowired
  private CommisionLevelDAO commisionLevelDAO;

  @Override
  @Transactional(readOnly = true)
  public CommisionLevel findByLevel(int level) {
    return commisionLevelDAO.findByLevel(level);
  }

  @Override
  public Page<CommisionLevel> findAll(int page, int rows, String sord, String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return commisionLevelDAO.findAll(pageable);
  }

}
