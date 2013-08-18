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
 * Accounts
 */
@Entity
@Table(name = "accounts")
public class Accounts implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2815902877080779725L;
  private long id;
  private Integer version;
  private User user;
  private String particular;
  private BigDecimal debit;
  private BigDecimal creditCommision;
  private BigDecimal creditToRoot;
  private Date createdAt;
  private Date updatedAt;

  public Accounts() {
  }

  public Accounts(long id, String particular, BigDecimal debit) {
    this.id = id;
    this.particular = particular;
    this.debit = debit;
  }

  public Accounts(long id, User user, String particular, BigDecimal debit,
      BigDecimal creditCommision, BigDecimal creditToRoot,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.particular = particular;
    this.debit = debit;
    this.creditCommision = creditCommision;
    this.creditToRoot = creditToRoot;
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
  @Column(name = "version")
  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "particular", nullable = false, length = 100)
  public String getParticular() {
    return this.particular;
  }

  public void setParticular(String particular) {
    this.particular = particular;
  }

  @Column(name = "debit", nullable = false, precision = 10)
  public BigDecimal getDebit() {
    return this.debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  @Column(name = "credit_commision", precision = 10)
  public BigDecimal getCreditCommision() {
    return this.creditCommision;
  }

  public void setCreditCommision(BigDecimal creditCommision) {
    this.creditCommision = creditCommision;
  }

  @Column(name = "credit_to_root", precision = 10)
  public BigDecimal getCreditToRoot() {
    return this.creditToRoot;
  }

  public void setCreditToRoot(BigDecimal creditToRoot) {
    this.creditToRoot = creditToRoot;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", length = 19)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", length = 19)
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

}
