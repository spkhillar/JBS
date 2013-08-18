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
 * JobsFunctionalArea
 */
@Entity
@Table(name = "jobs_functional_area")
public class JobsFunctionalArea implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8032245198955638725L;
  private long id;
  private int version;
  private String name;
  private String description;
  private String category;
  private Date createdAt;
  private Date updatedAt;

  public JobsFunctionalArea() {
  }

  public JobsFunctionalArea(long id, String name, String category,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public JobsFunctionalArea(long id, String name, String description,
      String category, Date createdAt, Date updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
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

  @Column(name = "name", nullable = false, length = 200)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "description", length = 200)
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "category", nullable = false, length = 200)
  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
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
