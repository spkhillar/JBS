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
 * SecurityQuestion.
 */
@Entity
@Table(name = "security_question")
public class SecurityQuestion implements BaseEntity, java.io.Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 6929786073324478900L;

  /** The id. */
  private long id;

  /** The version. */
  private int version;

  /** The question. */
  private String question;

  /** The created at. */
  private Date createdAt=new Date();

  /** The updated at. */
  private Date updatedAt;

  /**
   * Instantiates a new security question.
   */
  public SecurityQuestion() {
  }

  /**
   * Instantiates a new security question.
   *
   * @param id the id
   * @param question the question
   * @param createdAt the created at
   * @param updatedAt the updated at
   */
  public SecurityQuestion(long id, String question, Date createdAt,
      Date updatedAt) {
    this.id = id;
    this.question = question;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  @Id
  @Column(name = "ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return this.id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  @Version
  @Column(name = "version", nullable = false)
  public int getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(int version) {
    this.version = version;
  }

  /**
   * Gets the question.
   *
   * @return the question
   */
  @Column(name = "question", nullable = false, length = 300)
  public String getQuestion() {
    return this.question;
  }

  /**
   * Sets the question.
   *
   * @param question the new question
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * Gets the created at.
   *
   * @return the created at
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Sets the created at.
   *
   * @param createdAt the new created at
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets the updated at.
   *
   * @return the updated at
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false, length = 19)
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Sets the updated at.
   *
   * @param updatedAt the new updated at
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }



  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SecurityQuestion [id=");
    builder.append(id);
    builder.append(", ");
    if (question != null) {
      builder.append("question=");
      builder.append(question);
      builder.append(", ");
    }
    if (createdAt != null) {
      builder.append("createdAt=");
      builder.append(createdAt);
    }
    builder.append("]");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (question == null ? 0 : question.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
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
    SecurityQuestion other = (SecurityQuestion) obj;
    if (question == null) {
      if (other.question != null) {
        return false;
      }
    } else if (!question.equals(other.question)) {
      return false;
    }
    return true;
  }



}
