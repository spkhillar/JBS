package com.jpa.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

import com.jpa.entities.enums.ModeOfRedemption;
import com.jpa.entities.enums.RedeemStatus;

/**
 * RedeemHistory
 */
@Entity
@Table(name = "redeem_history")
@JsonAutoDetect(JsonMethod.NONE)
public class RedeemHistory implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3782555847645505912L;
  @JsonProperty
  private long id;
  private int version;
  @JsonProperty
  private User user;
  @JsonProperty
  private int points;
  @JsonProperty
  private ModeOfRedemption modeOfRedemption;
  @JsonProperty
  private String modeDetails;
  @JsonProperty
  private RedeemStatus status;
  @JsonProperty
  private Date createdAt = new Date();
  private Date updatedAt;
  private Set<Payment> payments = new HashSet<Payment>(0);

  public RedeemHistory() {}

  public RedeemHistory(final User user, final int points, final ModeOfRedemption modeOfRedemption,
      final String modeDetails, final RedeemStatus status, final Date updatedAt) {
    this.user = user;
    this.points = points;
    this.modeOfRedemption = modeOfRedemption;
    this.modeDetails = modeDetails;
    this.status = status;
    this.updatedAt = updatedAt;
  }

  public RedeemHistory(final long id, final User user, final int points, final ModeOfRedemption modeOfRedemption,
      final String modeDetails, final RedeemStatus status, final Date updatedAt, final Set<Payment> payments) {
    this.id = id;
    this.user = user;
    this.points = points;
    this.modeOfRedemption = modeOfRedemption;
    this.modeDetails = modeDetails;
    this.status = status;
    this.updatedAt = updatedAt;
    this.payments = payments;
  }

  @Id
  @Column(name = "ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  @Version
  @Column(name = "version", nullable = false)
  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  @Column(name = "points", nullable = false)
  public int getPoints() {
    return this.points;
  }

  public void setPoints(final int points) {
    this.points = points;
  }

  @Enumerated
  @Column(name = "mode_of_redemption", nullable = false, length = 100)
  public ModeOfRedemption getModeOfRedemption() {
    return this.modeOfRedemption;
  }

  public void setModeOfRedemption(final ModeOfRedemption modeOfRedemption) {
    this.modeOfRedemption = modeOfRedemption;
  }

  @Column(name = "mode_details", nullable = false, length = 512)
  public String getModeDetails() {
    return this.modeDetails;
  }

  public void setModeDetails(final String modeDetails) {
    this.modeDetails = modeDetails;
  }

  @Enumerated
  @Column(name = "status", nullable = false, length = 100)
  public RedeemStatus getStatus() {
    return this.status;
  }

  public void setStatus(final RedeemStatus status) {
    this.status = status;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false, length = 19)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false, length = 19)
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "redeemHistory")
  public Set<Payment> getPayments() {
    return this.payments;
  }

  public void setPayments(final Set<Payment> payments) {
    this.payments = payments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (modeDetails == null ? 0 : modeDetails.hashCode());
    result = prime * result + (modeOfRedemption == null ? 0 : modeOfRedemption.hashCode());
    result = prime * result + points;
    result = prime * result + (status == null ? 0 : status.hashCode());
    result = prime * result + (user == null ? 0 : user.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    RedeemHistory other = (RedeemHistory) obj;
    if (modeDetails == null) {
      if (other.modeDetails != null) {
        return false;
      }
    } else if (!modeDetails.equals(other.modeDetails)) {
      return false;
    }
    if (modeOfRedemption != other.modeOfRedemption) {
      return false;
    }
    if (points != other.points) {
      return false;
    }
    if (status != other.status) {
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
    builder.append("RedeemHistory [");
    if (user != null) {
      builder.append("user=");
      builder.append(user);
      builder.append(", ");
    }
    builder.append("points=");
    builder.append(points);
    builder.append(", ");
    if (modeOfRedemption != null) {
      builder.append("modeOfRedemption=");
      builder.append(modeOfRedemption);
      builder.append(", ");
    }
    if (modeDetails != null) {
      builder.append("modeDetails=");
      builder.append(modeDetails);
      builder.append(", ");
    }
    if (status != null) {
      builder.append("status=");
      builder.append(status);
      builder.append(", ");
    }
    builder.append("getId()=");
    builder.append(getId());
    builder.append(", getVersion()=");
    builder.append(getVersion());
    builder.append(", ");
    if (getUser() != null) {
      builder.append("getUser()=");
      builder.append(getUser());
      builder.append(", ");
    }
    builder.append("getPoints()=");
    builder.append(getPoints());
    builder.append(", ");
    if (getModeOfRedemption() != null) {
      builder.append("getModeOfRedemption()=");
      builder.append(getModeOfRedemption());
      builder.append(", ");
    }
    if (getModeDetails() != null) {
      builder.append("getModeDetails()=");
      builder.append(getModeDetails());
      builder.append(", ");
    }
    if (getStatus() != null) {
      builder.append("getStatus()=");
      builder.append(getStatus());
      builder.append(", ");
    }
    if (getCreatedAt() != null) {
      builder.append("getCreatedAt()=");
      builder.append(getCreatedAt());
      builder.append(", ");
    }
    if (getUpdatedAt() != null) {
      builder.append("getUpdatedAt()=");
      builder.append(getUpdatedAt());
      builder.append(", ");
    }
    if (getPayments() != null) {
      builder.append("getPayments()=");
      builder.append(getPayments());
      builder.append(", ");
    }
    builder.append("hashCode()=");
    builder.append(hashCode());
    builder.append(", ");
    if (getClass() != null) {
      builder.append("getClass()=");
      builder.append(getClass());
      builder.append(", ");
    }
    if (super.toString() != null) {
      builder.append("toString()=");
      builder.append(super.toString());
    }
    builder.append("]");
    return builder.toString();
  }

}
