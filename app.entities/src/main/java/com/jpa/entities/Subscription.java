package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.jpa.entities.enums.SubscriptionType;

/**
 * Subscription
 */
@Entity
@Table(name = "subscription")
public class Subscription implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6111047615622195223L;
  private long id;
  private int version;
  private User user;
  private Subscription subscription;
  private boolean enabled;
  private Date startDate;
  private Date endDate;
  private SubscriptionType subscriptionType;
  private int subscriptionDuration;
  private Date createdAt;
  private Date updatedAt;

  public Subscription() {}

  public Subscription(long id, User user, Date startDate, Date endDate, Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Subscription(long id, User user, Subscription subscription, boolean enabled, Date startDate, Date endDate,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.subscription = subscription;
    this.enabled = enabled;
    this.startDate = startDate;
    this.endDate = endDate;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "derived_from")
  public Subscription getSubscription() {
    return this.subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

  @Column(name = "enabled")
  public boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "start_date", nullable = false, length = 19)
  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "end_date", nullable = false, length = 19)
  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Enumerated
  @Column(name = "subscription_type", nullable = false)
  public SubscriptionType getSubscriptionType() {
    return subscriptionType;
  }

  public void setSubscriptionType(SubscriptionType subscriptionType) {
    this.subscriptionType = subscriptionType;
  }

  @Column(name = "subscription_duration", nullable = false)
  public int getSubscriptionDuration() {
    return subscriptionDuration;
  }

  public void setSubscriptionDuration(int subscriptionDuration) {
    this.subscriptionDuration = subscriptionDuration;
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
