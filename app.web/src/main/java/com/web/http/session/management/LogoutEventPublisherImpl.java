/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.web.http.session.management;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jpa.entities.User;
import com.web.event.LogoutSuccessEvent;

/**
 * The Class LogoutEventPublisherImpl.
 * @author 
 */
public class LogoutEventPublisherImpl implements LogoutEventPublisher {

  /**
   * Gets the web application context.
   *
   * @param request the request
   * @return the web application context
   */
  private WebApplicationContext getWebApplicationContext(final HttpServletRequest request){
    return   WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
  }

  /**
   * Publish.
   *
   * @param request the request
   * @param user the user
   * @see com.web.http.session.management.LogoutEventPublisher#publish(javax.servlet.http.HttpServletRequest, com.jpa.entities.User)
   */
  @Override
  public void publish(final HttpServletRequest request,final User user) {
    WebApplicationContext appx = getWebApplicationContext(request);
    LogoutSuccessEvent event = new LogoutSuccessEvent(user);
    System.err.println(".....");
    appx.publishEvent(event);
  }

}
