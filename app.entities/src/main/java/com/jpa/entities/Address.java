package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
  private Date createdAt = new Date();
  private Date updatedAt;
  private User user;

  public Address() {}

  public Address(String addressLine1, String city, String state, String pin) {
    this.addressLine1 = addressLine1;
    this.city = city;
    this.state = state;
    this.pin = pin;
  }

  public Address(String addressLine1, String addressLine2, String city, String state, String pin, User user) {
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.state = state;
    this.pin = pin;
    this.user = user;
  }

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(generator = "gen")
  @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
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
  @Column(name = "created_at", length = 19, updatable = false)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", length = 19, nullable = false)
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @PrimaryKeyJoinColumn
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (addressLine1 == null ? 0 : addressLine1.hashCode());
    result = prime * result + (city == null ? 0 : city.hashCode());
    result = prime * result + (pin == null ? 0 : pin.hashCode());
    result = prime * result + (state == null ? 0 : state.hashCode());
    result = prime * result + (user == null ? 0 : user.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Address other = (Address) obj;
    if (addressLine1 == null) {
      if (other.addressLine1 != null) {
        return false;
      }
    } else if (!addressLine1.equals(other.addressLine1)) {
      return false;
    }
    if (city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!city.equals(other.city)) {
      return false;
    }
    if (pin == null) {
      if (other.pin != null) {
        return false;
      }
    } else if (!pin.equals(other.pin)) {
      return false;
    }
    if (state == null) {
      if (other.state != null) {
        return false;
      }
    } else if (!state.equals(other.state)) {
      return false;
    }
    if (user == null) {
      if (other.user != null) {
        return false;
      }
    } else if (!user.equals(other.user)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Address [");
    if (addressLine1 != null) {
      builder.append("addressLine1=");
      builder.append(addressLine1);
      builder.append(", ");
    }
    if (city != null) {
      builder.append("city=");
      builder.append(city);
      builder.append(", ");
    }
    if (state != null) {
      builder.append("state=");
      builder.append(state);
      builder.append(", ");
    }
    if (pin != null) {
      builder.append("pin=");
      builder.append(pin);
      builder.append(", ");
    }
    if (createdAt != null) {
      builder.append("createdAt=");
      builder.append(createdAt);
    }
    builder.append("]");
    return builder.toString();
  }

}
