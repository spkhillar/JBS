package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.CommisionLevel;

public interface CommisionLevelService {

  public CommisionLevel findByLevel(int level);

  public Page<CommisionLevel> findAll(int page, int rows, String sord, String sidx);
}
