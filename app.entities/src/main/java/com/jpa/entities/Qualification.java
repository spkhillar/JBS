package com.jpa.entities;



import java.math.BigDecimal;
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
 * Qualification
 */
@Entity
@Table(name = "qualification")
public class Qualification implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7164751518712769632L;
  private long id;
  private int version;
  private User user;
  private String certification;
  private String boardOrUniversity;
  private int yearOfPassing;
  private BigDecimal percentage;
  private Date createdAt;
  private Date updatedAt;

  public Qualification() {
  }

  public Qualification(long id, User user, String certification,
      String boardOrUniversity, int yearOfPassing, BigDecimal percentage,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.certification = certification;
    this.boardOrUniversity = boardOrUniversity;
    this.yearOfPassing = yearOfPassing;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "certification", nullable = false, length = 300)
  public String getCertification() {
    return this.certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  @Column(name = "board_or_university", nullable = false, length = 300)
  public String getBoardOrUniversity() {
    return this.boardOrUniversity;
  }

  public void setBoardOrUniversity(String boardOrUniversity) {
    this.boardOrUniversity = boardOrUniversity;
  }

  @Column(name = "year_of_passing", nullable = false)
  public int getYearOfPassing() {
    return this.yearOfPassing;
  }

  public void setYearOfPassing(int yearOfPassing) {
    this.yearOfPassing = yearOfPassing;
  }

  @Column(name = "percentage", nullable = false, precision = 5)
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
