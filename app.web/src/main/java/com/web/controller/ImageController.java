package com.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.impl.SystemConfiguration;
import com.service.util.ServiceUtil;

@Controller
public class ImageController extends BaseController {

	@Autowired
	private SystemConfiguration systemConfiguration;

	@RequestMapping(value = "/static-jsp")
	public String staticJspContent(HttpServletRequest httpServletRequest) {

		System.err.println("....htppservlet..."
				+ httpServletRequest.getRequestURL());
		System.err.println("....htppservlet..."
				+ httpServletRequest.getContextPath());
		return "static-jsp";
	}

	@RequestMapping(value = "/image")
	public void image(
			@RequestParam(value = "imagefilename", required = false) final String imagefilename,
			HttpServletResponse response) throws IOException {

		// String filename = URLDecoder.decode(request.getPathInfo(), "UTF-8");
		File file = new File(systemConfiguration.getImageUploadDirectory(),
				imagefilename);
		response.setContentType(ServiceUtil.getImageMimeType(imagefilename));
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition",
				"inline; filename=\"" + file.getName() + "\"");

		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			input = new BufferedInputStream(new FileInputStream(file));
			output = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[8192];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException ignore) {
				}
			if (input != null)
				try {
					input.close();
				} catch (IOException ignore) {
				}
		}
	}

}
