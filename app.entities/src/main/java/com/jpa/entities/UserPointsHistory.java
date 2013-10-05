package com.jpa.entities;

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
 * UserPointsHistory
 */
@Entity
@Table(name = "user_points_history")
public class UserPointsHistory implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4125035882852647548L;
  private long id;
  private int version;
  private User user;
  private int point;
  private int total;
  private boolean enabled;
  private Date createdAt = new Date();
  private Date updatedAt;

  public UserPointsHistory() {}

  public UserPointsHistory(User user, int point, int total, Date updatedAt) {
    this.user = user;
    this.point = point;
    this.total = total;
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

  @Column(name = "point", nullable = false)
  public int getPoint() {
    return this.point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  @Column(name = "total", nullable = false)
  public int getTotal() {
    return this.total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  @Column(name = "enabled")
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
    result = prime * result + point;
    result = prime * result + total;
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
    UserPointsHistory other = (UserPointsHistory) obj;
    if (createdAt == null) {
      if (other.createdAt != null) {
        return false;
      }
    } else if (!createdAt.equals(other.createdAt)) {
      return false;
    }
    if (point != other.point) {
      return false;
    }
    if (total != other.total) {
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
    builder.append("UserPointsHistory [");
    if (user != null) {
      builder.append("user=");
      builder.append(user);
      builder.append(", ");
    }
    builder.append("point=");
    builder.append(point);
    builder.append(", total=");
    builder.append(total);
    builder.append("]");
    return builder.toString();
  }

}
