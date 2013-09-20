package com.jpa.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.jpa.entities.User;
import com.jpa.entities.UserGroups;
import com.jpa.repositories.GenericQueryExecutorDAO;

public class GenericQueryExecutorTest extends BaseTest {

  @Autowired
  private GenericQueryExecutorDAO genericQueryExecutorDAO;

  @Test
  public void test123() {
    long grpId = 1l;
    String query = "from UserGroups ug where ug.userByGroupId.id=" + grpId;

    genericQueryExecutorDAO.executeQuery(query, UserGroups.class);
  }

  // @Test
  public void testGenericQuery() {
    /*
     * List<User> userList =
     * genericQueryExecutorDAO.executeQuery("from User where enabled=0"
     * ,User.class); if(CollectionUtils.isNotEmpty(userList)){
     * System.err.println("..User.."+userList.get(0)); }
     */

    Page<User> pages = genericQueryExecutorDAO.executeQuery("from User", User.class, 1, 10);
    printList(pages);

    pages = genericQueryExecutorDAO.executeQuery("from User where userName like '%root%'", User.class, 2, 10);
    printList(pages);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("userName", "%root%");
    pages = genericQueryExecutorDAO.executeQuery("from Site where name like :state", User.class, params, 2, 10);
    printList(pages);

  }

  public void printList(Page<?> data) {

    if (data != null) {
      System.err.println("--------------------------------------------");
      System.err.println("...data..num=" + data.getNumber() + ":total=" + data.getTotalElements() + ":pages="
          + data.getTotalPages());
      int i = 0;
      for (Object object : data) {
        i++;
        System.err.println(i + "...Data..." + object);
      }
    } else {
      System.err.println("..Null data...");
    }

  }
}
