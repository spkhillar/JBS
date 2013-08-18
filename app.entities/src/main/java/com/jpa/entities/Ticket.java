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
 * Ticket
 */
@Entity
@Table(name = "ticket")
public class Ticket implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6149140477136154072L;
  private long id;
  private int version;
  private User user;
  private String enquiryOrComplainText;
  private String replyText;
  private String discriminator;
  private String status;
  private Date createdAt;
  private Date updatedAt;

  public Ticket() {
  }

  public Ticket(long id, User user, String enquiryOrComplainText,
      String status, Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.enquiryOrComplainText = enquiryOrComplainText;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Ticket(long id, User user, String enquiryOrComplainText,
      String replyText, String discriminator, String status,
      Date createdAt, Date updatedAt) {
    this.id = id;
    this.user = user;
    this.enquiryOrComplainText = enquiryOrComplainText;
    this.replyText = replyText;
    this.discriminator = discriminator;
    this.status = status;
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

  @Column(name = "enquiry_or_complain_text", nullable = false, length = 1000)
  public String getEnquiryOrComplainText() {
    return this.enquiryOrComplainText;
  }

  public void setEnquiryOrComplainText(String enquiryOrComplainText) {
    this.enquiryOrComplainText = enquiryOrComplainText;
  }

  @Column(name = "reply_text", length = 1000)
  public String getReplyText() {
    return this.replyText;
  }

  public void setReplyText(String replyText) {
    this.replyText = replyText;
  }

  @Column(name = "discriminator", length = 50)
  public String getDiscriminator() {
    return this.discriminator;
  }

  public void setDiscriminator(String discriminator) {
    this.discriminator = discriminator;
  }

  @Column(name = "status", nullable = false, length = 50)
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
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
