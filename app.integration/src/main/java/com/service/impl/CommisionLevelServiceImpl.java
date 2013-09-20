package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CommisionLevel;
import com.jpa.repositories.CommisionLevelDAO;
import com.service.CommisionLevelService;

@Service("commisionLevelService")
public class CommisionLevelServiceImpl implements CommisionLevelService {

  @Autowired
  private CommisionLevelDAO commisionLevelDAO;

  @Override
  @Transactional(readOnly = true)
  public CommisionLevel findByLevel(int level) {
    return commisionLevelDAO.findByLevel(level);
  }

}
