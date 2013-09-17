package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.jpa.entities.enums.MlmUserCreditPointStatus;

/**
 * Degree
 */
@Entity
@Table(name = "mlm_user_credit_point")
public class MlmUserCreditPoint implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8032245198955638725L;
  private long id;
  private int version;

  private int points;
  private MlmUserCreditPointStatus mlmUserCreditPointStatus;
  private User user;
  private DepositIntimator depositIntimator;
  private MlmUserCreditPoint transferredUserCreditPoint;
  private Date createdAt = new Date();
  private Date updatedAt;

  public MlmUserCreditPoint() {}

  public MlmUserCreditPoint(long id, Date createdAt, Date updatedAt) {
    this.id = id;
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

  @Column(name = "points", nullable = false)
  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  public MlmUserCreditPointStatus getMlmUserCreditPointStatus() {
    return mlmUserCreditPointStatus;
  }

  public void setMlmUserCreditPointStatus(MlmUserCreditPointStatus mlmUserCreditPointStatus) {
    this.mlmUserCreditPointStatus = mlmUserCreditPointStatus;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deposit_intimator_id")
  public DepositIntimator getDepositIntimator() {
    return depositIntimator;
  }

  public void setDepositIntimator(DepositIntimator depositIntimator) {
    this.depositIntimator = depositIntimator;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "transfer_id")
  public MlmUserCreditPoint getTransferredUserCreditPoint() {
    return transferredUserCreditPoint;
  }

  public void setTransferredUserCreditPoint(MlmUserCreditPoint transferredUserCreditPoint) {
    this.transferredUserCreditPoint = transferredUserCreditPoint;
  }

  @Version
  @Column(name = "version", nullable = false)
  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
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
