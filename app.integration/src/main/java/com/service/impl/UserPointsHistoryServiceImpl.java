package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.User;
import com.jpa.entities.UserPointsHistory;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.UserPointsHistoryDAO;
import com.service.UserPointsHistoryService;

@Service("userPointsHistoryService")
public class UserPointsHistoryServiceImpl implements UserPointsHistoryService {

  @Autowired
  private UserPointsHistoryDAO userPointsHistoryDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Override
  @Transactional
  public UserPointsHistory save(UserPointsHistory userPointsHistory) {
    return userPointsHistoryDAO.save(userPointsHistory);
  }

  @Override
  @Transactional(readOnly = true)
  public int getLastUserPointTotal(User user) {
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
}
