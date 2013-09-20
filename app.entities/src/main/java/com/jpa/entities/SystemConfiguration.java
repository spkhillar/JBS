package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * SystemConfiguration
 */
@Entity
@Table(name = "system_configuration")
public class SystemConfiguration implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1453277217032014984L;
  private long id;
  private int version = 0;
  private String key;
  private String value;
  private Date createdAt = new Date();
  private Date updatedAt;

  public SystemConfiguration() {}

  public SystemConfiguration(String key, String value, Date updatedAt) {
    this.key = key;
    this.value = value;
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

  @Column(name = "key", nullable = false, length = 512)
  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Column(name = "value", nullable = false, length = 512)
  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
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
    result = prime * result + (key == null ? 0 : key.hashCode());
    result = prime * result + (value == null ? 0 : value.hashCode());
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
    SystemConfiguration other = (SystemConfiguration) obj;
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SystemConfiguration [");
    if (key != null) {
      builder.append("key=");
      builder.append(key);
      builder.append(", ");
    }
    if (value != null) {
      builder.append("value=");
      builder.append(value);
    }
    builder.append("]");
    return builder.toString();
  }

}
