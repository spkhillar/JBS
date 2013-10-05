package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.RedeemHistory;
import com.jpa.entities.User;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.RedeemHistoryDAO;
import com.service.RedeemHistoryService;

@Service("redeemHistoryService")
public class RedeemHistoryServiceImpl implements RedeemHistoryService {

  @Autowired
  private RedeemHistoryDAO redeemHistoryDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Override
  @Transactional
  public RedeemHistory save(RedeemHistory redeemHistory) {
    return redeemHistoryDAO.save(redeemHistory);
  }

  @Override
  @Transactional(readOnly = true)
  public int sumOfPointBy(User user) {
    String ejbql = "select sum(rh.points) from RedeemHistory rh where rh.user.id = :userId";
    Map<String, Object> params = new HashMap<String, Object>(1);
    params.put("userId", user.getId());
    List<Long> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (list.get(0) == null) {
      return 0;
    }
    return list.get(0).intValue();
  }
}
