package com.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Accounts;
import com.jpa.entities.CommisionLevel;
import com.jpa.entities.SystemConfiguration;
import com.jpa.entities.User;
import com.jpa.entities.UserGroups;
import com.jpa.entities.UserPointsHistory;
import com.jpa.entities.enums.UserPosition;
import com.jpa.repositories.GenericQueryExecutorDAO;
import com.jpa.repositories.UserDAO;
import com.jpa.repositories.UserGroupsDAO;
import com.service.AccountsService;
import com.service.CommisionLevelService;
import com.service.SystemConfigurationService;
import com.service.UserGroupService;
import com.service.UserPointsHistoryService;
import com.service.util.ApplicationConstants;
import com.service.util.ServiceUtil;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {

  private static final Logger logger = Logger.getLogger(UserGroupServiceImpl.class);

  @Autowired
  private UserGroupsDAO userGroupsDAO;

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Autowired
  private CommisionLevelService commisionLevelService;

  @Autowired
  private SystemConfigurationService systemConfigurationService;

  @Autowired
  private UserPointsHistoryService userPointsHistoryService;

  @Autowired
  private AccountsService accountsService;

  @Override
  @Transactional
  public void addToGroup(User currentUser, String parentMlmId, UserPosition position) {
    User parentUser = null;
    if (StringUtils.isBlank(parentMlmId)) {
      parentUser = userDAO.findByUserName("root");
    } else {
      parentUser = userDAO.findByMlmAccountId(parentMlmId);
    }
    UserGroups parentUserGroups = userGroupsDAO.findByUserByGroupId(parentUser);
    int level = parentUserGroups.getLevel() + 1;
    UserGroups userGroups = new UserGroups(currentUser, parentUser, level, position, new Date());
    parentUser.getUserGroupsesForParentGroupId().add(userGroups);
    currentUser.getUserGroupsesForGroupId().add(userGroups);
    userGroupsDAO.save(userGroups);
  }

  @Override
  @Transactional(readOnly = true)
  public void findChild(String username, List<User> userList) {
    User grp = userDAO.findByUserName(username);
    if (grp != null) {
      Set<UserGroups> groups = grp.getUserGroupsesForParentGroupId();
      if (CollectionUtils.isNotEmpty(groups)) {
        for (UserGroups groups2 : groups) {
          if (groups2.getUserByGroupId() != null) {
            userList.add(groups2.getUserByGroupId());
            findChild(groups2.getUserByGroupId().getUserName(), userList);
          }
        }
      }
    }
  }

  @Override
  @Transactional(readOnly = true)
  public User findMlmAdminUser(User parentUser, UserPosition userPosition) {
    User user = null;
    UserGroups userGroups = userGroupsDAO.findByUserByParentGroupIdAndPosition(parentUser, userPosition);
    if (userGroups != null) {
      user = userGroups.getUserByGroupId();
    }
    user.getUserSecurityQuestion().getSecurityQuestion();
    return user;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Long> findUserGroupsBy(Date startDate, Date endDate, boolean commisionPayed) {
    String query =
        "select ug.id from UserGroups ug where ug.createdAt between :startDate and :endDate "
            + "and ug.commisionPayed = :commisionPayed order by ug.createdAt desc";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("startDate", startDate);
    params.put("endDate", endDate);
    params.put("commisionPayed", commisionPayed);
    List<Long> userGroupIds = genericQueryExecutorDAO.executeProjectedQuery(query, params);
    return userGroupIds;
  }

  @Override
  @Transactional
  public List<Long> allocateCommision(Date startDate, Date endDate) {
    logger.info("####start allocateCommision from " + startDate + " TO " + endDate);
    SystemConfiguration systemConfiguration =
        systemConfigurationService.findByKey(ApplicationConstants.SUBSCRIPTION_BASE_PRICE);
    int subscriptionBasePrice = Integer.valueOf(systemConfiguration.getValue());
    List<Long> idList = findUserGroupsBy(startDate, endDate, false);
    logger.info("Processing IDs..." + idList);
    for (Long userGroupId : idList) {
      try {
        allocateCommisionToUser(userGroupId, subscriptionBasePrice);
      } catch (Exception e) {
        logger.error("Exception processing userGroupId=" + userGroupId, e);
      }
    }
    logger.info("###end allocateCommision ");
    return idList;
  }

  @Override
  @Transactional
  public void updateCommisionForCurrentDay(List<Long> idList) {
    for (Long userGroupId : idList) {
      try {
        checkForBinaryCompletionOfParents(userGroupId);
      } catch (Exception e) {
        logger.error("Exception processing updateCommisionForCurrentDay for userGroupId=" + userGroupId, e);
      }
    }
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkIfUserHasBinary(User user) {
    if (user.getUserGroupsesForParentGroupId().size() < 2) {
      return false;
    }
    return true;
  }

  private void checkForBinaryCompletionOfParents(Long userGroupId) {
    UserGroups userGroup = userGroupsDAO.findOne(userGroupId);
    int currentLevel = userGroup.getLevel();
    if (currentLevel > 0) {
      User user = userGroup.getUserByParentGroupId();
      if (user.getUserGroupsesForParentGroupId().size() == 2) {
        checkForDisabledUserPoints(user);
      }
    }
  }

  private void checkForDisabledUserPoints(User user) {
    logger.info("..checkForDisabledUserPoints starts for User=" + user.getUserName());
    int page = 1;
    Pageable pageable = ServiceUtil.getPage(page, 10);
    Page<UserPointsHistory> list = userPointsHistoryService.findUserPointByUserName(user, pageable);
    while (list.hasContent()) {
      logger.info("..Processing Page =" + page);
      for (UserPointsHistory userPointsHistory : list) {
        userPointsHistory.setEnabled(true);
        userPointsHistory.setUpdatedAt(new Date());
        userPointsHistoryService.save(userPointsHistory);
      }
      page++;
      pageable = ServiceUtil.getPage(page, 10);
      list = userPointsHistoryService.findUserPointByUserName(user, pageable);
    }
    logger.info("..checkForDisabledUserPoints ends for User=" + user.getUserName());
  }

  private void allocateCommisionToUser(Long userGroupId, int subscriptionBasePrice) {
    UserGroups userGroup = userGroupsDAO.findOne(userGroupId);
    logger.info("----starts-----" + userGroup.getUserByGroupId().getUserName());
    int currentLevel = 1;
    int userLevel = 0;
    User parentUser = null;
    String userName = userGroup.getUserByGroupId().getUserName();
    String tempUserName = null;
    UserGroups currentUserGrp = userGroup;
    BigDecimal totalPaid = BigDecimal.valueOf(0l);
    CommisionLevel commisionLevel = null;
    BigDecimal commsionPercentage = null;
    do {
      parentUser = currentUserGrp.getUserByParentGroupId();
      logger.info("...processing..." + userName);
      tempUserName = parentUser.getUserName();
      currentUserGrp = parentUser.getUserGroupsesForGroupId().iterator().next();
      currentLevel = currentUserGrp.getLevel();
      logger.info("Parent of " + userName + " is " + tempUserName + " and is at level " + currentLevel);
      userLevel++;

      if (currentLevel == -1) {
        // do nothing
      } else if (currentLevel == 0) {
        commsionPercentage = BigDecimal.valueOf(100l).subtract(totalPaid);
        int points = addUserPoints(parentUser, commsionPercentage, subscriptionBasePrice, true);
        logger.info("...Allocating commision to admin..." + parentUser.getUserName() + " @ " + commsionPercentage
            + ". Points Collected =" + points);
        createAccountsRecord(userGroup.getUserByGroupId(), commsionPercentage, totalPaid, subscriptionBasePrice);
      } else if (parentUser.getUserGroupsesForParentGroupId().size() == 2 && currentLevel > 0) {
        commisionLevel = commisionLevelService.findByLevel(userLevel);
        commsionPercentage = commisionLevel.getPercentage();
        totalPaid = totalPaid.add(commisionLevel.getPercentage());
        int points = addUserPoints(parentUser, commsionPercentage, subscriptionBasePrice, true);
        logger.info("...Allocating commision to..." + parentUser.getUserName() + " @ " + commsionPercentage
            + ". Points Collected =" + points);
      } else if (parentUser.getUserGroupsesForParentGroupId().size() == 1) {
        commisionLevel = commisionLevelService.findByLevel(userLevel);
        commsionPercentage = commisionLevel.getPercentage();
        totalPaid = totalPaid.add(commisionLevel.getPercentage());
        int points = addUserPoints(parentUser, commsionPercentage, subscriptionBasePrice, false);
        logger.info("...Allocating disabled commision to..." + parentUser.getUserName() + " @ " + commsionPercentage
            + ". Points Collected =" + points);
      }
      if (parentUser != null) {
        userName = parentUser.getUserName();
      }
    } while (currentLevel > 0 && userLevel < 19);

    logger.info("----ends-----" + userGroup.getUserByGroupId().getUserName());
  }

  private void createAccountsRecord(User user, BigDecimal commsionPercentage, BigDecimal totalPaid,
      int subscriptionBasePrice) {
    BigDecimal debit = BigDecimal.valueOf(subscriptionBasePrice);
    BigDecimal creditCommision = totalPaid.divide(BigDecimal.valueOf(100l)).multiply(debit);
    BigDecimal creditToRoot = debit.subtract(creditCommision);
    Accounts accounts =
        new Accounts(user, ApplicationConstants.MLM_ACCOUNTS_PARTICULAR, debit, creditCommision, creditToRoot,
          new Date());
    accountsService.save(accounts);
    logger.info("Created Accounts record from user" + user.getUserName() + ". Accounts=" + accounts);
  }

  private int addUserPoints(User parentUser, BigDecimal commsionPercentage, int subscriptionBasePrice, boolean enabled) {
    BigDecimal finalPoints =
        commsionPercentage.divide(BigDecimal.valueOf(100l)).multiply(BigDecimal.valueOf(subscriptionBasePrice));
    int lastTotal = userPointsHistoryService.getLastUserPointTotal(parentUser);

    Long currentTotal = finalPoints.longValue() + lastTotal;
    logger.info(parentUser.getUserName() + " -- Last points=" + lastTotal + ".currentTotal=" + currentTotal);
    UserPointsHistory userPointsHistory =
        new UserPointsHistory(parentUser, finalPoints.intValue(), currentTotal.intValue(), new Date());
    userPointsHistory.setEnabled(enabled);
    userPointsHistoryService.save(userPointsHistory);
    return finalPoints.intValue();
  }
}
