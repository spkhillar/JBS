package com.jpa.entities;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * RedeemHistory
 */
@Entity
@Table(name = "redeem_history")
public class RedeemHistory implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3782555847645505912L;
  private long id;
  private int version;
  private User user;
  private int points;
  private String modeOfRedemption;
  private String modeDetails;
  private String status;
  private Date createdAt;
  private Date updatedAt;
  private Set<Payment> payments = new HashSet<Payment>(0);

  public RedeemHistory() {
  }

  public RedeemHistory(long id, User user, int points,
      String modeOfRedemption, String modeDetails, String status,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.points = points;
    this.modeOfRedemption = modeOfRedemption;
    this.modeDetails = modeDetails;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RedeemHistory(long id, User user, int points,
      String modeOfRedemption, String modeDetails, String status,
      Date createdAt, Date updatedAt, Set<Payment> payments) {
    this.id = id;
    this.user = user;
    this.points = points;
    this.modeOfRedemption = modeOfRedemption;
    this.modeDetails = modeDetails;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.payments = payments;
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

  @Column(name = "points", nullable = false)
  public int getPoints() {
    return this.points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Column(name = "mode_of_redemption", nullable = false, length = 100)
  public String getModeOfRedemption() {
    return this.modeOfRedemption;
  }

  public void setModeOfRedemption(String modeOfRedemption) {
    this.modeOfRedemption = modeOfRedemption;
  }

  @Column(name = "mode_details", nullable = false, length = 512)
  public String getModeDetails() {
    return this.modeDetails;
  }

  public void setModeDetails(String modeDetails) {
    this.modeDetails = modeDetails;
  }

  @Column(name = "status", nullable = false, length = 100)
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "redeemHistory")
  public Set<Payment> getPayments() {
    return this.payments;
  }

  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
  }

}
