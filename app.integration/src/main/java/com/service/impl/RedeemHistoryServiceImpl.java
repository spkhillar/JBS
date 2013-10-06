package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;
import com.jpa.entities.enums.RedeemStatus;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.RedeemHistoryDAO;
import com.service.RedeemHistoryService;
import com.service.util.ServiceUtil;

@Service("redeemHistoryService")
public class RedeemHistoryServiceImpl implements RedeemHistoryService {

  @Autowired
  private RedeemHistoryDAO redeemHistoryDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Override
  @Transactional
  public RedeemHistory save(final RedeemHistory redeemHistory) {
    return redeemHistoryDAO.save(redeemHistory);
  }

  @Override
  @Transactional(readOnly = true)
  public int sumOfPointBy(final User user) {
    String ejbql = "select sum(rh.points) from RedeemHistory rh where rh.user.id = :userId";
    Map<String, Object> params = new HashMap<String, Object>(1);
    params.put("userId", user.getId());
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RedeemHistory> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return redeemHistoryDAO.findByStatus(RedeemStatus.NEW, pageable);

  }

}
