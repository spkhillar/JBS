/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.service;

import com.service.mail.EmailTemplate;

/**
 * The Interface EmailService.
 *
 * @author 
 */
public interface EmailService {

  /**
   * Send email.
   *
   * @param emailTemplate the email template
   */
  public void sendEmail(EmailTemplate emailTemplate);

}
