package com.web;

import org.junit.Test;

import com.jpa.entities.User;
import com.service.util.ServiceUtil;
import com.web.form.UserRegistrationForm;

public class TestMimeType {

  @Test
  public void testMimeType() {

    String fileName = "test.JPG";
    System.err.println("...Collection.." + ServiceUtil.getImageMimeType(fileName));
    UserRegistrationForm form = new UserRegistrationForm();
    User user = new User();
    user.setUserName("swadhin");
    form.setUser(user);
    form.getUser().setUserName("");
  }
}
