package com.web.form;

import java.util.List;

import com.jpa.entities.Job;

public class JobForm {

  private Job job = new Job();

  private String designation;

  private String otherDesignation;

  private boolean newJob = true;

  private String companyJobUrl;

  private List<String> degreeList;

  private List<String> selectedDegreeList;



  public Job getJob() {
    return job;
  }

  public void setJob(final Job job) {
    this.job = job;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(final String designation) {
    this.designation = designation;
  }

  public String getOtherDesignation() {
    return otherDesignation;
  }

  public void setOtherDesignation(final String otherDesignation) {
    this.otherDesignation = otherDesignation;
  }

  public boolean isNewJob() {
    return newJob;
  }

  public void setNewJob(final boolean newJob) {
    this.newJob = newJob;
  }

  public String getCompanyJobUrl() {
    return companyJobUrl;
  }

  public void setCompanyJobUrl(final String companyJobUrl) {
    this.companyJobUrl = companyJobUrl;
  }

  public List<String> getDegreeList() {
    return degreeList;
  }

  public void setDegreeList(final List<String> degreeList) {
    this.degreeList = degreeList;
  }

  public List<String> getSelectedDegreeList() {
    return selectedDegreeList;
  }

  public void setSelectedDegreeList(final List<String> selectedDegreeList) {
    this.selectedDegreeList = selectedDegreeList;
  }


}
