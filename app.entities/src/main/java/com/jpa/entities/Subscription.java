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
  private Boolean enabled;
  private Date startDate;
  private Date endDate;
  private Date createdAt;
  private Date updatedAt;
  private Set<Subscription> subscriptions = new HashSet<Subscription>(0);

  public Subscription() {
  }

  public Subscription(long id, User user, Date startDate, Date endDate,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Subscription(long id, User user, Subscription subscription,
      Boolean enabled, Date startDate, Date endDate, Date createdAt,
      Date updatedAt, Set<Subscription> subscriptions) {
    this.id = id;
    this.user = user;
    this.subscription = subscription;
    this.enabled = enabled;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.subscriptions = subscriptions;
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
  public Boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled) {
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscription")
  public Set<Subscription> getSubscriptions() {
    return this.subscriptions;
  }

  public void setSubscriptions(Set<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }

}
