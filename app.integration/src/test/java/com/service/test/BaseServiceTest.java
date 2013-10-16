package com.service.test;

import java.util.Date;

import org.springframework.test.context.ContextConfiguration;

import com.jpa.entities.Address;
import com.jpa.entities.User;
import com.jpa.test.BaseTest;

@ContextConfiguration(locations = { "classpath:applicationContext-service.xml",
    "classpath:applicationContext-rest-client.xml" }, inheritLocations = true)
public class BaseServiceTest extends BaseTest {

  protected User getUser(String username) {
    User newUser = new User(username, "shivsambhu1234", "fname1", "lastName1", "abc@gmail.com", true, "98887655");
    newUser.setDateOfBirth(new Date());
    Address address = new Address("add1", null, "city", "state", "67777", newUser);
    newUser.setAddress(address);
    return newUser;
  }

}
