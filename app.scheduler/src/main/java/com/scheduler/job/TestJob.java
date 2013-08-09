/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.scheduler.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * The Class TestJob.
 *
 * @author 
 */
public class TestJob extends QuartzJobBean {

	/**
	 * Execute internal.
	 *
	 * @param arg0 the arg0
	 * @throws JobExecutionException the job execution exception
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub

	}

}
