package com.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.service.UserService;

public class UserServiceTest extends BaseServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void test() {
    List<User> u = userService.findUserBy("root", null, null, null, -1, null);
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", "root", null, null, -1, null);
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", null, "root@gmail.com", null, -1, null);
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", null, null, "11111", -1, null);
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", "root", "root@gmail.com", "11111", -1, null);
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", "root", "root@gmail.com", "11111", 3, "none");
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root", "root", "root@gmail.com", "11111", 3, "none");
    Assert.assertTrue(u.size() == 1);
    u = userService.findUserBy("root1", "root", "root@gmail.com", "11111", 3, "none");
    Assert.assertTrue(u == null);
  }

  @Test
  public void testMatchPassword() {
    boolean b = userService.matchPassword("root", "root", "root1");
    System.err.println("..boolean.." + b);
    b = userService.matchPassword("root", "root1", "root");
    System.err.println("..boolean.." + b);
  }

}
