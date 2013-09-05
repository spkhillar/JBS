package com.service.test;

import org.springframework.test.context.ContextConfiguration;

import com.jpa.test.BaseTest;

@ContextConfiguration(locations = { "classpath:applicationContext-service.xml",
    "classpath:applicationContext-rest-client.xml" }, inheritLocations = true)
public class BaseServiceTest extends BaseTest {

}
