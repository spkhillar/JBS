package com.jpa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.jpa.repositories.UserDAO;

public class UserDaoTest extends BaseTest{

  @Autowired
  private UserDAO userDao;
  
  @Test
  public void testUser(){
    
    User user = userDao.findOne(1L);
    
    System.err.println("..Users..."+user);
  }
  
}
