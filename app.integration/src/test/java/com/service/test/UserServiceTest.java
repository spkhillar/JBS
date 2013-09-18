package com.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.service.UserService;

public class UserServiceTest extends BaseServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void test() {
    User u = userService.findUserBy("root", null, null, null);
    u = userService.findUserBy("root", "root", null, null);
    u = userService.findUserBy("root", null, "root@gmail.com", null);
    u = userService.findUserBy("root", null, null, "11111");
    u = userService.findUserBy("root", "root", "root@gmail.com", "11111");

  }

  @Test
  public void testMatchPassword() {
    boolean b = userService.matchPassword("root", "root", "root1");
    System.err.println("..boolean.." + b);
    b = userService.matchPassword("root", "root1", "root");
    System.err.println("..boolean.." + b);
  }

}
