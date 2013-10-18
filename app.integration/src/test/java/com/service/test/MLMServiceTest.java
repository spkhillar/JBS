package com.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.jpa.entities.UserGroups;
import com.jpa.entities.enums.UserPosition;
import com.service.UserGroupService;
import com.service.UserRegistrationService;
import com.service.UserService;

public class MLMServiceTest extends BaseServiceTest {

  @Autowired
  private UserRegistrationService userRegistrationService;

  @Autowired
  private UserGroupService userGroupService;

  @Autowired
  private UserService userService;

  // @Test
  public void testFindGrp() {
    User user = userService.findByUserName("root");

    User userMlm = userGroupService.findMlmAdminUser(user, UserPosition.L);
    System.err.println("..." + userMlm.getId());

  }

  /**
   * 
   * root 1 2 3 4 5 6 7 8 9 10
   * 
   */
  @Test
  public void payCommssion() {
    boolean pay = false;
    Date startDate = new Date();
    List<User> savedUserList = new ArrayList<User>();
    Map<String, String> mlmMap = new HashMap<String, String>();
    for (int i = 1; i <= 14; i++) {
      User user = getUser("A" + i);
      User savedUser = userRegistrationService.saveMlmUser(user, 1L, "shiv", null, null, null, 3l);
      savedUserList.add(savedUser);
      mlmMap.put(savedUser.getUserName(), savedUser.getMlmAccountId());
    }
    /*
     * for (Map.Entry<String, String> entry : mlmMap.entrySet()) {
     * System.err.println(entry.getKey() + "...entry.." + entry.getValue()); }
     */
    addMlmToGroups(savedUserList, mlmMap);
    checkAndShowChilds("A3", false);
    Date endDate = new Date();
    if (pay) {
      List<Long> ids = userGroupService.allocateCommision(startDate, endDate);
    }
    // userGroupService.updateCommisionForCurrentDay(ids);
    System.err.println("..yes,,,");
    // userGroupService.findChild("A8");
  }

  private void checkAndShowChilds(String username, boolean left) {
    User user = userService.findByUserName(username);
    Set<UserGroups> groups = user.getUserGroupsesForParentGroupId();
    UserGroups targetUserGroups = null;
    UserGroups tmpUserGroups = null;
    System.err.println("..Groups .." + groups.size());
    if (groups.size() == 2) {
      tmpUserGroups = groups.iterator().next();
      if (left) {
        System.err.println("..Searching left: first" + tmpUserGroups);
        if (UserPosition.L.equals(tmpUserGroups.getPosition())) {
          targetUserGroups = tmpUserGroups;
        }
        if (targetUserGroups == null) {
          tmpUserGroups = groups.iterator().next();
          System.err.println("..Searching left: second" + tmpUserGroups);
          if (UserPosition.L.equals(tmpUserGroups.getPosition())) {
            targetUserGroups = tmpUserGroups;
          }
        }
      } else {
        if (UserPosition.R.equals(tmpUserGroups.getPosition())) {
          targetUserGroups = tmpUserGroups;
        }
        if (targetUserGroups == null) {
          tmpUserGroups = groups.iterator().next();
          if (UserPosition.R.equals(tmpUserGroups.getPosition())) {
            targetUserGroups = tmpUserGroups;
          }
        }
      }

    } else {
      tmpUserGroups = groups.iterator().next();
      if (left) {
        if (UserPosition.L.equals(tmpUserGroups.getPosition())) {
          targetUserGroups = tmpUserGroups;
        }
      } else {
        if (UserPosition.R.equals(tmpUserGroups.getPosition())) {
          targetUserGroups = tmpUserGroups;
        }
      }
    }

    List<User> userList = new ArrayList<User>();
    if (targetUserGroups != null) {
      userList.add(targetUserGroups.getUserByGroupId());
      System.err.println("..First " + targetUserGroups.getUserByGroupId().getUserName());
      userGroupService.findChild(targetUserGroups.getUserByGroupId().getUserName(), userList);
    }

    for (User user2 : userList) {
      System.err.println("..." + user2);
    }
  }

  private void addMlmToGroups(List<User> savedUserList, Map<String, String> mlmMap) {
    String parentMlmId = null;
    User currentUser = userService.findByUserName("A1");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A2");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);
    currentUser = userService.findByUserName("A3");
    parentMlmId = mlmMap.get("A1");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A4");
    parentMlmId = mlmMap.get("A3");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A5");
    parentMlmId = mlmMap.get("A3");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);
    currentUser = userService.findByUserName("A6");
    parentMlmId = mlmMap.get("A5");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A7");
    parentMlmId = mlmMap.get("A5");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);
    currentUser = userService.findByUserName("A8");
    parentMlmId = mlmMap.get("A6");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A9");
    parentMlmId = mlmMap.get("A8");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A10");
    parentMlmId = mlmMap.get("A8");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);
    currentUser = userService.findByUserName("A11");
    parentMlmId = mlmMap.get("A2");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);
    currentUser = userService.findByUserName("A12");
    parentMlmId = mlmMap.get("A11");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A13");
    parentMlmId = mlmMap.get("A12");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.L);
    currentUser = userService.findByUserName("A14");
    parentMlmId = mlmMap.get("A12");
    waitFor();
    userGroupService.addToGroup(currentUser, parentMlmId, UserPosition.R);

  }

  private void waitFor() {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
