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

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Job
 */
@Entity
@Table(name = "job")
@JsonAutoDetect(JsonMethod.NONE)
public class Job implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2793323235829513319L;
  @JsonProperty
  private long id;
  private int version;
  @JsonProperty
  private String jobTitle;
  private String jobDescription;
  @JsonProperty
  private String jobType;
  @JsonProperty
  private String jobCode;
  @JsonProperty
  private Date postedAt;
  @JsonProperty
  private String industry;
  private int jobValidDuration;
  private Boolean enabled;
  @JsonProperty
  private String companyName;
  private String companyUrl;
  private String qualification;
  private String salary;
  private String keyword;
  private String skill;
  @JsonProperty
  private String designation;
  private String experiance;
  private String location;
  @JsonProperty
  private String category;
  @JsonProperty
  private String subCategory;
  private String ageLimit;
  private Date createdAt = new Date();
  private Date updatedAt;

  public Job() {}

  public Job(long id, String jobTitle, String jobDescription, String jobType, Date postedAt, String industry,
      int jobValidDuration, String companyName, String qualification, String salary, String keyword, String skill,
      String designation, String experiance, String location, Date createdAt, Date updatedAt) {
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

  public Job(long id, String jobTitle, String jobDescription, String jobType, String jobCode, Date postedAt,
      String industry, int jobValidDuration, Boolean enabled, String companyName, String companyUrl,
      String qualification, String salary, String keyword, String skill, String designation, String experiance,
      String location, Date createdAt, Date updatedAt) {
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

  @Column(name = "category", nullable = false, length = 200)
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Column(name = "sub_category", nullable = false, length = 200)
  public String getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }

  @Column(name = "age_limit", nullable = false, length = 20)
  public String getAgeLimit() {
    return ageLimit;
  }

  public void setAgeLimit(String ageLimit) {
    this.ageLimit = ageLimit;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false, length = 19)
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (category == null ? 0 : category.hashCode());
    result = prime * result + (companyName == null ? 0 : companyName.hashCode());
    result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
    result = prime * result + (jobTitle == null ? 0 : jobTitle.hashCode());
    result = prime * result + (location == null ? 0 : location.hashCode());
    result = prime * result + (postedAt == null ? 0 : postedAt.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Job other = (Job) obj;
    if (category == null) {
      if (other.category != null) {
        return false;
      }
    } else if (!category.equals(other.category)) {
      return false;
    }
    if (companyName == null) {
      if (other.companyName != null) {
        return false;
      }
    } else if (!companyName.equals(other.companyName)) {
      return false;
    }
    if (createdAt == null) {
      if (other.createdAt != null) {
        return false;
      }
    } else if (!createdAt.equals(other.createdAt)) {
      return false;
    }
    if (jobTitle == null) {
      if (other.jobTitle != null) {
        return false;
      }
    } else if (!jobTitle.equals(other.jobTitle)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (postedAt == null) {
      if (other.postedAt != null) {
        return false;
      }
    } else if (!postedAt.equals(other.postedAt)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Job [");
    if (jobTitle != null) {
      builder.append("jobTitle=");
      builder.append(jobTitle);
      builder.append(", ");
    }
    if (jobDescription != null) {
      builder.append("jobDescription=");
      builder.append(jobDescription);
      builder.append(", ");
    }
    if (jobType != null) {
      builder.append("jobType=");
      builder.append(jobType);
      builder.append(", ");
    }
    if (jobCode != null) {
      builder.append("jobCode=");
      builder.append(jobCode);
      builder.append(", ");
    }
    if (postedAt != null) {
      builder.append("postedAt=");
      builder.append(postedAt);
      builder.append(", ");
    }
    if (industry != null) {
      builder.append("industry=");
      builder.append(industry);
      builder.append(", ");
    }
    builder.append("jobValidDuration=");
    builder.append(jobValidDuration);
    builder.append(", ");
    if (enabled != null) {
      builder.append("enabled=");
      builder.append(enabled);
      builder.append(", ");
    }
    if (companyName != null) {
      builder.append("companyName=");
      builder.append(companyName);
      builder.append(", ");
    }
    if (companyUrl != null) {
      builder.append("companyUrl=");
      builder.append(companyUrl);
      builder.append(", ");
    }
    if (qualification != null) {
      builder.append("qualification=");
      builder.append(qualification);
      builder.append(", ");
    }
    if (salary != null) {
      builder.append("salary=");
      builder.append(salary);
      builder.append(", ");
    }
    if (keyword != null) {
      builder.append("keyword=");
      builder.append(keyword);
      builder.append(", ");
    }
    if (skill != null) {
      builder.append("skill=");
      builder.append(skill);
      builder.append(", ");
    }
    if (designation != null) {
      builder.append("designation=");
      builder.append(designation);
      builder.append(", ");
    }
    if (experiance != null) {
      builder.append("experiance=");
      builder.append(experiance);
      builder.append(", ");
    }
    if (location != null) {
      builder.append("location=");
      builder.append(location);
      builder.append(", ");
    }
    if (category != null) {
      builder.append("category=");
      builder.append(category);
      builder.append(", ");
    }
    if (subCategory != null) {
      builder.append("subCategory=");
      builder.append(subCategory);
      builder.append(", ");
    }
    if (ageLimit != null) {
      builder.append("ageLimit=");
      builder.append(ageLimit);
    }
    builder.append("]");
    return builder.toString();
  }

}
