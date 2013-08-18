package com.jpa.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Job
 */
@Entity
@Table(name = "job")
public class Job implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2793323235829513319L;
  private long id;
  private int version;
  private String jobTitle;
  private String jobDescription;
  private String jobType;
  private String jobCode;
  private Date postedAt;
  private String industry;
  private int jobValidDuration;
  private Boolean enabled;
  private String companyName;
  private String companyUrl;
  private String qualification;
  private String salary;
  private String keyword;
  private String skill;
  private String designation;
  private String experiance;
  private String location;
  private Date createdAt;
  private Date updatedAt;

  public Job() {
  }

  public Job(long id, String jobTitle, String jobDescription, String jobType,
      Date postedAt, String industry, int jobValidDuration,
      String companyName, String qualification, String salary,
      String keyword, String skill, String designation,
      String experiance, String location, Date createdAt, Date updatedAt) {
    this.id = id;
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
    this.jobType = jobType;
    this.postedAt = postedAt;
    this.industry = industry;
    this.jobValidDuration = jobValidDuration;
    this.companyName = companyName;
    this.qualification = qualification;
    this.salary = salary;
    this.keyword = keyword;
    this.skill = skill;
    this.designation = designation;
    this.experiance = experiance;
    this.location = location;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Job(long id, String jobTitle, String jobDescription, String jobType,
      String jobCode, Date postedAt, String industry,
      int jobValidDuration, Boolean enabled, String companyName,
      String companyUrl, String qualification, String salary,
      String keyword, String skill, String designation,
      String experiance, String location, Date createdAt, Date updatedAt) {
    this.id = id;
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
    this.jobType = jobType;
    this.jobCode = jobCode;
    this.postedAt = postedAt;
    this.industry = industry;
    this.jobValidDuration = jobValidDuration;
    this.enabled = enabled;
    this.companyName = companyName;
    this.companyUrl = companyUrl;
    this.qualification = qualification;
    this.salary = salary;
    this.keyword = keyword;
    this.skill = skill;
    this.designation = designation;
    this.experiance = experiance;
    this.location = location;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @Id
  @Column(name = "ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Version
  @Column(name = "version", nullable = false)
  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Column(name = "job_title", nullable = false, length = 100)
  public String getJobTitle() {
    return this.jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  @Column(name = "job_description", nullable = false, length = 1000)
  public String getJobDescription() {
    return this.jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  @Column(name = "job_type", nullable = false, length = 50)
  public String getJobType() {
    return this.jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  @Column(name = "job_code", length = 50)
  public String getJobCode() {
    return this.jobCode;
  }

  public void setJobCode(String jobCode) {
    this.jobCode = jobCode;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "posted_at", nullable = false, length = 19)
  public Date getPostedAt() {
    return this.postedAt;
  }

  public void setPostedAt(Date postedAt) {
    this.postedAt = postedAt;
  }

  @Column(name = "industry", nullable = false, length = 100)
  public String getIndustry() {
    return this.industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  @Column(name = "job_valid_duration", nullable = false)
  public int getJobValidDuration() {
    return this.jobValidDuration;
  }

  public void setJobValidDuration(int jobValidDuration) {
    this.jobValidDuration = jobValidDuration;
  }

  @Column(name = "enabled")
  public Boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  @Column(name = "company_name", nullable = false, length = 250)
  public String getCompanyName() {
    return this.companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Column(name = "company_url", length = 250)
  public String getCompanyUrl() {
    return this.companyUrl;
  }

  public void setCompanyUrl(String companyUrl) {
    this.companyUrl = companyUrl;
  }

  @Column(name = "qualification", nullable = false, length = 250)
  public String getQualification() {
    return this.qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  @Column(name = "salary", nullable = false, length = 50)
  public String getSalary() {
    return this.salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  @Column(name = "keyword", nullable = false, length = 500)
  public String getKeyword() {
    return this.keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  @Column(name = "skill", nullable = false, length = 500)
  public String getSkill() {
    return this.skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  @Column(name = "designation", nullable = false, length = 100)
  public String getDesignation() {
    return this.designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  @Column(name = "experiance", nullable = false, length = 50)
  public String getExperiance() {
    return this.experiance;
  }

  public void setExperiance(String experiance) {
    this.experiance = experiance;
  }

  @Column(name = "location", nullable = false, length = 200)
  public String getLocation() {
    return this.location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false, length = 19)
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

}
