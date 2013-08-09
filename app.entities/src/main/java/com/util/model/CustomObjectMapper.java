/*
 * Copyright (C) 2013 , Inc. All rights reserved 
 */
package com.util.model;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * The Class CustomObjectMapper.
 * 
 * @author 
 */
public class CustomObjectMapper extends ObjectMapper {

	/**
	 * Instantiates a new custom object mapper.
	 */
	public CustomObjectMapper() {
		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		setDateFormat(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
	}

}
