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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Address
 */
@Entity
@Table(name = "address")
public class Address implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6009026565404413496L;
  private Long id;
  private Integer version;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String pin;
  private Date createdAt;
  private Date updatedAt;
  private Set<User> users = new HashSet<User>(0);

  public Address() {
  }

  public Address(String addressLine1, String city, String state, String pin) {
    this.addressLine1 = addressLine1;
    this.city = city;
    this.state = state;
    this.pin = pin;
  }

  public Address(String addressLine1, String addressLine2, String city,
      String state, String pin, Date createdAt, Date updatedAt,
      Set<User> users) {
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.state = state;
    this.pin = pin;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.users = users;
  }

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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

  @Column(name = "address_line1", nullable = false, length = 250)
  public String getAddressLine1() {
    return this.addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  @Column(name = "address_line2", length = 250)
  public String getAddressLine2() {
    return this.addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  @Column(name = "city", nullable = false, length = 100)
  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Column(name = "state", nullable = false, length = 100)
  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Column(name = "pin", nullable = false, length = 10)
  public String getPin() {
    return this.pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  public Set<User> getUsers() {
    return this.users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

}
