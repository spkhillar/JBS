package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.User;
import com.jpa.entities.UserPointsHistory;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.UserDAO;
import com.jpa.repositories.UserPointsHistoryDAO;
import com.service.RedeemHistoryService;
import com.service.UserPointsHistoryService;
import com.service.util.ServiceUtil;

@Service("userPointsHistoryService")
public class UserPointsHistoryServiceImpl implements UserPointsHistoryService {

  @Autowired
  private UserPointsHistoryDAO userPointsHistoryDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private RedeemHistoryService reedeHistoryService;

  @Override
  @Transactional
  public UserPointsHistory save(final UserPointsHistory userPointsHistory) {
    return userPointsHistoryDAO.save(userPointsHistory);
  }

  @Override
  @Transactional(readOnly = true)
  public int getLastUserPointTotal(final User user) {
    // Pageable pageable = ServiceUtil.getPage(1, 1, "desc", "id");
    String ejbql =
        "select uph.total from UserPointsHistory uph where uph.id = (select max(uph1.id) from UserPointsHistory uph1 where uph1.user.id=:userId)";

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("userId", user.getId());
    List<Integer> list = genericQueryExecutorDAO.executeProjectedQuery(ejbql, params);
    if (CollectionUtils.isEmpty(list)) {
      return 0;
    }
    return list.get(0);
    /*
     * Page<UserPointsHistory> list = userPointsHistoryDAO.findByUser(user,
     * pageable); if (list.getTotalElements() == 0l) { return 0; }
     */
    // return list.iterator().next().getTotal();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<UserPointsHistory> findUserPointByUserName(final User user, final int page, final int rows,
      final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return userPointsHistoryDAO.findByUserAndEnabled(user, true, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<UserPointsHistory> findSystemIncentivePoint(final int page, final int rows, final String sord,
      final String sidx) {
    List<User> userList = userDAO.findByRole(6L);
    String[] orderByFields = new String[] { "user.userName", "total" };
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, orderByFields);
    return userPointsHistoryDAO.findByUserIn(userList, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public int getUserTotalPoint(final User user) {
    int totalPoints = getLastUserPointTotal(user);
    int totalRedeemPoints = reedeHistoryService.sumOfPointBy(user);
    return totalPoints - totalRedeemPoints;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<UserPointsHistory> findUserPointByUserName(final User user, Pageable page) {
    return userPointsHistoryDAO.findByUserAndEnabled(user, false, page);
  }

}
