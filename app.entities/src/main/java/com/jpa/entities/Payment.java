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
 * Payment
 */
@Entity
@Table(name = "payment")
@JsonAutoDetect(JsonMethod.NONE)
public class Payment implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 539478124505992361L;
  @JsonProperty
  private long id;
  private int version;
  private RedeemHistory redeemHistory;
  @JsonProperty
  private BigDecimal amount;
  private Date paymentDate;
  @JsonProperty
  private Date createdAt = new Date();
  private Date updatedAt;

  public Payment() {}

  public Payment(final BigDecimal amount, final Date paymentDate, final Date updatedAt) {
    this.amount = amount;
    this.paymentDate = paymentDate;
    this.updatedAt = updatedAt;
  }

  public Payment(final RedeemHistory redeemHistory, final BigDecimal amount, final Date paymentDate, final Date updatedAt) {
    this.redeemHistory = redeemHistory;
    this.amount = amount;
    this.paymentDate = paymentDate;
    this.updatedAt = updatedAt;
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
  @JoinColumn(name = "redeem_id")
  public RedeemHistory getRedeemHistory() {
    return this.redeemHistory;
  }

  public void setRedeemHistory(final RedeemHistory redeemHistory) {
    this.redeemHistory = redeemHistory;
  }

  @Column(name = "amount", nullable = false, precision = 10)
  public BigDecimal getAmount() {
    return this.amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "payment_date", nullable = false, length = 19)
  public Date getPaymentDate() {
    return this.paymentDate;
  }

  public void setPaymentDate(final Date paymentDate) {
    this.paymentDate = paymentDate;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (paymentDate == null ? 0 : paymentDate.hashCode());
    result = prime * result + (redeemHistory == null ? 0 : redeemHistory.hashCode());
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
    Payment other = (Payment) obj;
    if (paymentDate == null) {
      if (other.paymentDate != null) {
        return false;
      }
    } else if (!paymentDate.equals(other.paymentDate)) {
      return false;
    }
    if (redeemHistory == null) {
      if (other.redeemHistory != null) {
        return false;
      }
    } else if (!redeemHistory.equals(other.redeemHistory)) {
      return false;
    }
    return true;
  }

}
