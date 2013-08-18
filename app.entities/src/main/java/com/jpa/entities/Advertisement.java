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
 * Advertisement
 */
@Entity
@Table(name = "advertisement")
public class Advertisement implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4794600097081504524L;
  private long id;
  private int version;
  private String title;
  private byte[] image;
  private String description;
  private String type;
  private int validDuration;
  private Boolean enabled;
  private Date ceatedAt;
  private Date updatedAt;

  public Advertisement() {
  }

  public Advertisement(long id, String title, String type, int validDuration,
      Date ceatedAt, Date updatedAt) {
    this.id = id;
    this.title = title;
    this.type = type;
    this.validDuration = validDuration;
    this.ceatedAt = ceatedAt;
    this.updatedAt = updatedAt;
  }

  public Advertisement(long id, String title, byte[] image,
      String description, String type, int validDuration,
      Boolean enabled, Date ceatedAt, Date updatedAt) {
    this.id = id;
    this.title = title;
    this.image = image;
    this.description = description;
    this.type = type;
    this.validDuration = validDuration;
    this.enabled = enabled;
    this.ceatedAt = ceatedAt;
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

  @Column(name = "title", nullable = false, length = 200)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "image")
  public byte[] getImage() {
    return this.image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  @Column(name = "description", length = 500)
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "type", nullable = false, length = 50)
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "valid_duration", nullable = false)
  public int getValidDuration() {
    return this.validDuration;
  }

  public void setValidDuration(int validDuration) {
    this.validDuration = validDuration;
  }

  @Column(name = "enabled")
  public Boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ceated_at", nullable = false, length = 19)
  public Date getCeatedAt() {
    return this.ceatedAt;
  }

  public void setCeatedAt(Date ceatedAt) {
    this.ceatedAt = ceatedAt;
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
