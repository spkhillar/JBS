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

/**
 * Qualification
 */
@Entity
@Table(name = "qualification")
public class Qualification implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7164751518712769632L;
  private long id;
  private int version;
  private User user;
  private Degree degree;
  private String boardOrUniversity;
  private int yearOfPassing;
  private BigDecimal percentage;
  private Date createdAt = new Date();
  private Date updatedAt;

  public Qualification() {}

  public Qualification(User user, Degree degree, String boardOrUniversity, int yearOfPassing, BigDecimal percentage) {
    this.user = user;
    this.degree = degree;
    this.boardOrUniversity = boardOrUniversity;
    this.yearOfPassing = yearOfPassing;
    this.percentage = percentage;
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

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "degree_id", nullable = false)
  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  @Column(name = "board_or_university", nullable = false, length = 300)
  public String getBoardOrUniversity() {
    return this.boardOrUniversity;
  }

  public void setBoardOrUniversity(String boardOrUniversity) {
    this.boardOrUniversity = boardOrUniversity;
  }

  @Column(name = "year_of_passing", nullable = false)
  public int getYearOfPassing() {
    return this.yearOfPassing;
  }

  public void setYearOfPassing(int yearOfPassing) {
    this.yearOfPassing = yearOfPassing;
  }

  @Column(name = "percentage", nullable = false, precision = 5)
  public BigDecimal getPercentage() {
    return this.percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
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
    result = prime * result + (boardOrUniversity == null ? 0 : boardOrUniversity.hashCode());
    result = prime * result + (percentage == null ? 0 : percentage.hashCode());
    result = prime * result + yearOfPassing;
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
    Qualification other = (Qualification) obj;
    if (boardOrUniversity == null) {
      if (other.boardOrUniversity != null) {
        return false;
      }
    } else if (!boardOrUniversity.equals(other.boardOrUniversity)) {
      return false;
    }
    if (percentage == null) {
      if (other.percentage != null) {
        return false;
      }
    } else if (!percentage.equals(other.percentage)) {
      return false;
    }
    if (yearOfPassing != other.yearOfPassing) {
      return false;
    }
    return true;
  }

}
