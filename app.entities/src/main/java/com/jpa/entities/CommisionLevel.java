package com.jpa.entities;



import java.math.BigDecimal;
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
 * CommisionLevel
 */
@Entity
@Table(name = "commision_level")
public class CommisionLevel implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -951642626769277245L;
  private long id;
  private int version;
  private int level;
  private String description;
  private BigDecimal percentage;
  private Date createdAt;
  private Date updatedAt;

  public CommisionLevel() {
  }

  public CommisionLevel(long id, int level, BigDecimal percentage,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.level = level;
    this.percentage = percentage;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public CommisionLevel(long id, int level, String description,
      BigDecimal percentage, Date createdAt, Date updatedAt) {
    this.id = id;
    this.level = level;
    this.description = description;
    this.percentage = percentage;
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

  @Column(name = "level", nullable = false)
  public int getLevel() {
    return this.level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  @Column(name = "description", length = 100)
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "percentage", nullable = false, precision = 6)
  public BigDecimal getPercentage() {
    return this.percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
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
