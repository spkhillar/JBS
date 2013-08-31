package com.web.form;

import com.jpa.entities.Job;

public class JobForm {

  private Job job = new Job();

  private String designation;

  private String otherDesignation;

  private boolean newJob = true;

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getOtherDesignation() {
    return otherDesignation;
  }

  public void setOtherDesignation(String otherDesignation) {
    this.otherDesignation = otherDesignation;
  }

  public boolean isNewJob() {
    return newJob;
  }

  public void setNewJob(boolean newJob) {
    this.newJob = newJob;
  }

}
