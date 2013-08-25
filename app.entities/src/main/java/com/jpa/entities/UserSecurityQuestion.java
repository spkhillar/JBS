package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * UserSecurityQuestion
 */
@Entity
@Table(name = "user_security_question")
public class UserSecurityQuestion implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 128970039607887170L;
  private Long id;
  private int version;
  private User user;
  private SecurityQuestion securityQuestion;
  private String answer;
  private Date createdAt = new Date();
  private Date updatedAt;

  public UserSecurityQuestion() {}

  public UserSecurityQuestion(User user, SecurityQuestion securityQuestion, String answer) {
    super();
    this.user = user;
    this.securityQuestion = securityQuestion;
    this.answer = answer;
  }

  @Id
  @GeneratedValue(generator = "gen")
  @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
  @Column(name = "id", unique = true, nullable = false)
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @PrimaryKeyJoinColumn
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id", nullable = false)
  public SecurityQuestion getSecurityQuestion() {
    return this.securityQuestion;
  }

  public void setSecurityQuestion(SecurityQuestion securityQuestion) {
    this.securityQuestion = securityQuestion;
  }

  @Column(name = "answer", nullable = false, length = 300)
  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19, updatable = false)
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
    result = prime * result + (answer == null ? 0 : answer.hashCode());
    result = prime * result + (securityQuestion == null ? 0 : securityQuestion.hashCode());
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
    UserSecurityQuestion other = (UserSecurityQuestion) obj;
    if (answer == null) {
      if (other.answer != null) {
        return false;
      }
    } else if (!answer.equals(other.answer)) {
      return false;
    }
    if (securityQuestion == null) {
      if (other.securityQuestion != null) {
        return false;
      }
    } else if (!securityQuestion.equals(other.securityQuestion)) {
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
    builder.append("UserSecurityQuestion [");
    if (securityQuestion != null) {
      builder.append("securityQuestion=");
      builder.append(securityQuestion);
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
