package com.jpa.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Skill
 */
@Entity
@Table(name = "skill")
public class Skill implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3370611286038238977L;
  private long id;
  private int version;
  private User user;
  private String skills;
  private byte[] resume;
  private String resumeFileName;
  private String functionalArea;
  private String yearOfExperiance;
  private Date createdAt = new Date();
  private Date updatedAt;

  public Skill() {}

  public Skill(User user, String skills, String functionalArea, String yearOfExperiance) {
    super();
    this.user = user;
    this.skills = skills;
    this.functionalArea = functionalArea;
    this.yearOfExperiance = yearOfExperiance;
  }

  @Id
  @GeneratedValue(generator = "gen")
  @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
  @Column(name = "id", unique = true, nullable = false)
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

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @PrimaryKeyJoinColumn
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "skills", nullable = false, length = 512)
  public String getSkills() {
    return this.skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "resume", nullable = false, length = 16777215)
  public byte[] getResume() {
    return this.resume;
  }

  public void setResume(byte[] resume) {
    this.resume = resume;
  }

  @Column(name = "functional_area", nullable = false, length = 100)
  public String getFunctionalArea() {
    return this.functionalArea;
  }

  public void setFunctionalArea(String functionalArea) {
    this.functionalArea = functionalArea;
  }

  @Column(name = "year_of_experiance", nullable = false, length = 100)
  public String getYearOfExperiance() {
    return yearOfExperiance;
  }

  public void setYearOfExperiance(String yearOfExperiance) {
    this.yearOfExperiance = yearOfExperiance;
  }

  @Column(name = "resume_filename", nullable = false, length = 512)
  public String getResumeFileName() {
    return resumeFileName;
  }

  public void setResumeFileName(String resumeFileName) {
    this.resumeFileName = resumeFileName;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (functionalArea == null ? 0 : functionalArea.hashCode());
    result = prime * result + (user == null ? 0 : user.hashCode());
    result = prime * result + (yearOfExperiance == null ? 0 : yearOfExperiance.hashCode());
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
    Skill other = (Skill) obj;
    if (functionalArea == null) {
      if (other.functionalArea != null) {
        return false;
      }
    } else if (!functionalArea.equals(other.functionalArea)) {
      return false;
    }
    if (user == null) {
      if (other.user != null) {
        return false;
      }
    } else if (!user.equals(other.user)) {
      return false;
    }
    if (yearOfExperiance == null) {
      if (other.yearOfExperiance != null) {
        return false;
      }
    } else if (!yearOfExperiance.equals(other.yearOfExperiance)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Skill [");
    if (skills != null) {
      builder.append("skills=");
      builder.append(skills);
      builder.append(", ");
    }
    if (functionalArea != null) {
      builder.append("functionalArea=");
      builder.append(functionalArea);
      builder.append(", ");
    }
    if (yearOfExperiance != null) {
      builder.append("yearOfExperiance=");
      builder.append(yearOfExperiance);
    }
    builder.append("]");
    return builder.toString();
  }

}
