package com.web;

import org.junit.Test;

import com.service.util.ServiceUtil;

public class TestMimeType {

	
	@Test
	public void testMimeType(){

		String fileName = "test.JPG";
		System.err.println("...Collection.."+ServiceUtil.getImageMimeType(fileName));
	}
}
