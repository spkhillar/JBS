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

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Accounts
 */
@Entity
@Table(name = "accounts")
@JsonAutoDetect(JsonMethod.NONE)
public class Accounts implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2815902877080779725L;
  @JsonProperty
  private long id;
  private Integer version;
  @JsonProperty
  private User user;
  @JsonProperty
  private String particular;
  @JsonProperty
  private BigDecimal debit;
  @JsonProperty
  private BigDecimal creditCommision;
  @JsonProperty
  private BigDecimal creditToRoot;
  @JsonProperty
  private Date createdAt = new Date();
  private Date updatedAt;

  public Accounts() {}

  public Accounts(long id, String particular, BigDecimal debit) {
    this.id = id;
    this.particular = particular;
    this.debit = debit;
  }

  public Accounts(User user, String particular, BigDecimal debit, BigDecimal creditCommision, BigDecimal creditToRoot,
      Date updatedAt) {
    this.user = user;
    this.particular = particular;
    this.debit = debit;
    this.creditCommision = creditCommision;
    this.creditToRoot = creditToRoot;
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

  @ManyToOne(fetch = FetchType.EAGER)
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

  @Column(name = "credit_commision", nullable = false, precision = 10)
  public BigDecimal getCreditCommision() {
    return this.creditCommision;
  }

  public void setCreditCommision(BigDecimal creditCommision) {
    this.creditCommision = creditCommision;
  }

  @Column(name = "credit_to_root", nullable = false, precision = 10)
  public BigDecimal getCreditToRoot() {
    return this.creditToRoot;
  }

  public void setCreditToRoot(BigDecimal creditToRoot) {
    this.creditToRoot = creditToRoot;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false, length = 19)
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
    result = prime * result + (creditCommision == null ? 0 : creditCommision.hashCode());
    result = prime * result + (creditToRoot == null ? 0 : creditToRoot.hashCode());
    result = prime * result + (debit == null ? 0 : debit.hashCode());
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
    Accounts other = (Accounts) obj;
    if (createdAt == null) {
      if (other.createdAt != null) {
        return false;
      }
    } else if (!createdAt.equals(other.createdAt)) {
      return false;
    }
    if (creditCommision == null) {
      if (other.creditCommision != null) {
        return false;
      }
    } else if (!creditCommision.equals(other.creditCommision)) {
      return false;
    }
    if (creditToRoot == null) {
      if (other.creditToRoot != null) {
        return false;
      }
    } else if (!creditToRoot.equals(other.creditToRoot)) {
      return false;
    }
    if (debit == null) {
      if (other.debit != null) {
        return false;
      }
    } else if (!debit.equals(other.debit)) {
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
    builder.append("Accounts [");
    if (user != null) {
      builder.append("user=");
      builder.append(user.getUserName());
      builder.append(", ");
    }
    if (particular != null) {
      builder.append("particular=");
      builder.append(particular);
      builder.append(", ");
    }
    if (debit != null) {
      builder.append("debit=");
      builder.append(debit);
      builder.append(", ");
    }
    if (creditCommision != null) {
      builder.append("creditCommision=");
      builder.append(creditCommision);
      builder.append(", ");
    }
    if (creditToRoot != null) {
      builder.append("creditToRoot=");
      builder.append(creditToRoot);
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
