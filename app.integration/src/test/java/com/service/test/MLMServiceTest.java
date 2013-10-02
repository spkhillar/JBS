package com.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.Address;
import com.jpa.entities.User;
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
  public void testmlm1() {
    userGroupService.findChild("shiv1");
  }

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
  public void testMlm() {
    Date startDate = new Date();
    List<User> savedUserList = new ArrayList<User>();
    Map<String, String> mlmMap = new HashMap<String, String>();
    for (int i = 1; i <= 14; i++) {
      User user = getUser("A" + i);
      User savedUser = userRegistrationService.saveMlmUser(user, 1L, "shiv", null, null, null, 3l);
      savedUserList.add(savedUser);
      mlmMap.put(savedUser.getUserName(), savedUser.getMlmAccountId());
    }
    for (Map.Entry<String, String> entry : mlmMap.entrySet()) {
      System.err.println(entry.getKey() + "...entry.." + entry.getValue());
    }
    addMlmToGroups(savedUserList, mlmMap);

    Date endDate = new Date();
    userGroupService.allocateCommision(startDate, endDate);
    System.err.println("..yes,,,");
    // userGroupService.findChild("A8");
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

  private User getUser(String username) {
    User newUser = new User(username, "shivsambhu1234", "fname1", "lastName1", "abc@gmail.com", true, "98887655");
    newUser.setDateOfBirth(new Date());
    Address address = new Address("add1", null, "city", "state", "67777", newUser);
    newUser.setAddress(address);
    return newUser;
  }

  private void waitFor() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
