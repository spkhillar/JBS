package com.jpa.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

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
  private String resume;
  private String functionalArea;
  private Date createdAt;
  private Date updatedAt;

  public Skill() {
  }

  public Skill(long id, User user, String skills, String resume,
      String functionalArea, Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.skills = skills;
    this.resume = resume;
    this.functionalArea = functionalArea;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
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

  @Column(name = "resume", nullable = false, length = 16777215)
  public String getResume() {
    return this.resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  @Column(name = "functional_area", nullable = false, length = 100)
  public String getFunctionalArea() {
    return this.functionalArea;
  }

  public void setFunctionalArea(String functionalArea) {
    this.functionalArea = functionalArea;
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
