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

import com.jpa.entities.enums.UserPosition;

/**
 * UserGroups
 */
@Entity
@Table(name = "user_groups")
public class UserGroups implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4894195921334241647L;
  private Long id;
  private Integer version;
  private User userByGroupId;
  private User userByParentGroupId;
  private int level;
  private UserPosition position;
  private Date createdAt = new Date();
  private Date updatedAt;

  public UserGroups() {}

  public UserGroups(User userByGroupId, int level, UserPosition position) {
    this.userByGroupId = userByGroupId;
    this.level = level;
    this.position = position;
  }

  public UserGroups(User userByGroupId, User userByParentGroupId, int level, UserPosition position, Date updatedAt) {
    this.userByGroupId = userByGroupId;
    this.userByParentGroupId = userByParentGroupId;
    this.level = level;
    this.position = position;
    this.updatedAt = updatedAt;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id", nullable = false)
  public User getUserByGroupId() {
    return this.userByGroupId;
  }

  public void setUserByGroupId(User userByGroupId) {
    this.userByGroupId = userByGroupId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_group_id")
  public User getUserByParentGroupId() {
    return this.userByParentGroupId;
  }

  public void setUserByParentGroupId(User userByParentGroupId) {
    this.userByParentGroupId = userByParentGroupId;
  }

  @Column(name = "level", nullable = false)
  public int getLevel() {
    return this.level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  @Enumerated
  @Column(name = "position", nullable = false, length = 1)
  public UserPosition getPosition() {
    return this.position;
  }

  public void setPosition(UserPosition position) {
    this.position = position;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + level;
    result = prime * result + (position == null ? 0 : position.hashCode());
    result = prime * result + (userByGroupId == null ? 0 : userByGroupId.hashCode());
    result = prime * result + (userByParentGroupId == null ? 0 : userByParentGroupId.hashCode());
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
    UserGroups other = (UserGroups) obj;
    if (level != other.level) {
      return false;
    }
    if (position == null) {
      if (other.position != null) {
        return false;
      }
    } else if (!position.equals(other.position)) {
      return false;
    }
    if (userByGroupId == null) {
      if (other.userByGroupId != null) {
        return false;
      }
    } else if (!userByGroupId.equals(other.userByGroupId)) {
      return false;
    }
    if (userByParentGroupId == null) {
      if (other.userByParentGroupId != null) {
        return false;
      }
    } else if (!userByParentGroupId.equals(other.userByParentGroupId)) {
      return false;
    }
    return true;
  }

}
