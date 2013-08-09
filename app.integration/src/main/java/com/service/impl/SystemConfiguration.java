/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The Class SystemConfiguration. Place holder to fetch properties defined in
 * system-config.properties.
 *
 * @author 
 */
@Service("systemConfig")
public class SystemConfiguration {

	@Value("${mail.host}")
	private String mailHost;
	
	@Value("${image.upload.location}")
	private String imageUploadDirectory;

	/**
	 * Gets the mail host.
	 *
	 * @return the mail host
	 */
	public String getMailHost() {
		return mailHost;
	}

	/**
	 * Sets the mail host.
	 *
	 * @param mailHost the new mail host
	 */
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getImageUploadDirectory() {
		return imageUploadDirectory;
	}

	public void setImageUploadDirectory(String imageUploadDirectory) {
		this.imageUploadDirectory = imageUploadDirectory;
	}
	
	
}
