package com.jpa.entities;

import java.math.BigDecimal;
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

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.DepositIntimatorType;
import com.jpa.entities.enums.PaymentMode;

/**
 * DepositIntimator
 */
@Entity
@Table(name = "deposit_intimator")
@JsonAutoDetect(JsonMethod.NONE)
public class DepositIntimator implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6027320354612393779L;
  @JsonProperty
  private long id;
  private int version;
  @JsonProperty
  private User userByUserId;
  private User userByReceiverUserId;
  @JsonProperty
  private BigDecimal amountDeposited;
  @JsonProperty
  private Date transactedDate;
  @JsonProperty
  private PaymentMode modeOfPayment;
  private Long transactionNumber;
  private byte[] receiptCopy;
  private String chequeNumber;
  private Date chequeDate;
  private String chequeDrawnOnBank;
  private String chequeDrawnBranch;
  private DepositIntimatorStatus status;
  @JsonProperty
  private DepositIntimatorType depositIntimatorType;
  private String description;
  private String cashDepositedBankName;
  private Date createdAt = new Date();
  private Date updatedAt;

  public DepositIntimator() {}

  public DepositIntimator(final long id, final User userByUserId, final BigDecimal amountDeposited,
      final Date transactedDate, final PaymentMode modeOfPayment, final DepositIntimatorStatus status,
      final Date createdAt, final Date updatedAt) {
    this.id = id;
    this.userByUserId = userByUserId;
    this.amountDeposited = amountDeposited;
    this.transactedDate = transactedDate;
    this.modeOfPayment = modeOfPayment;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public DepositIntimator(final long id, final User userByUserId, final User userByReceiverUserId,
      final BigDecimal amountDeposited, final Date transactedDate, final PaymentMode modeOfPayment,
      final Long transactionNumber, final byte[] receiptCopy, final String chequeNumber, final Date chequeDate,
      final String chequeDrawnOnBank, final String chequeDrawnBranch, final DepositIntimatorStatus status,
      final Date createdAt, final Date updatedAt) {
    this.id = id;
    this.userByUserId = userByUserId;
    this.userByReceiverUserId = userByReceiverUserId;
    this.amountDeposited = amountDeposited;
    this.transactedDate = transactedDate;
    this.modeOfPayment = modeOfPayment;
    this.transactionNumber = transactionNumber;
    this.receiptCopy = receiptCopy;
    this.chequeNumber = chequeNumber;
    this.chequeDate = chequeDate;
    this.chequeDrawnOnBank = chequeDrawnOnBank;
    this.chequeDrawnBranch = chequeDrawnBranch;
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
  public User getUserByUserId() {
    return this.userByUserId;
  }

  public void setUserByUserId(final User userByUserId) {
    this.userByUserId = userByUserId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "receiver_user_id")
  public User getUserByReceiverUserId() {
    return this.userByReceiverUserId;
  }

  public void setUserByReceiverUserId(final User userByReceiverUserId) {
    this.userByReceiverUserId = userByReceiverUserId;
  }

  @Column(name = "amount_deposited", nullable = false, precision = 10)
  public BigDecimal getAmountDeposited() {
    return this.amountDeposited;
  }

  public void setAmountDeposited(final BigDecimal amountDeposited) {
    this.amountDeposited = amountDeposited;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "transacted_date", nullable = false, length = 19)
  public Date getTransactedDate() {
    return this.transactedDate;
  }

  public void setTransactedDate(final Date transactedDate) {
    this.transactedDate = transactedDate;
  }

  @Enumerated
  @Column(name = "mode_of_payment", nullable = false, length = 50)
  public PaymentMode getModeOfPayment() {
    return this.modeOfPayment;
  }

  public void setModeOfPayment(final PaymentMode modeOfPayment) {
    this.modeOfPayment = modeOfPayment;
  }

  @Column(name = "transaction_number")
  public Long getTransactionNumber() {
    return this.transactionNumber;
  }

  public void setTransactionNumber(final Long transactionNumber) {
    this.transactionNumber = transactionNumber;
  }

  @Column(name = "receipt_copy")
  public byte[] getReceiptCopy() {
    return this.receiptCopy;
  }

  public void setReceiptCopy(final byte[] receiptCopy) {
    this.receiptCopy = receiptCopy;
  }

  @Column(name = "cheque_number", length = 50)
  public String getChequeNumber() {
    return this.chequeNumber;
  }

  public void setChequeNumber(final String chequeNumber) {
    this.chequeNumber = chequeNumber;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "cheque_date", length = 10)
  public Date getChequeDate() {
    return this.chequeDate;
  }

  public void setChequeDate(final Date chequeDate) {
    this.chequeDate = chequeDate;
  }

  @Column(name = "cheque_drawn_on_bank", length = 100)
  public String getChequeDrawnOnBank() {
    return this.chequeDrawnOnBank;
  }

  public void setChequeDrawnOnBank(final String chequeDrawnOnBank) {
    this.chequeDrawnOnBank = chequeDrawnOnBank;
  }

  @Column(name = "cheque_drawn_branch", length = 100)
  public String getChequeDrawnBranch() {
    return this.chequeDrawnBranch;
  }

  public void setChequeDrawnBranch(final String chequeDrawnBranch) {
    this.chequeDrawnBranch = chequeDrawnBranch;
  }

  @Enumerated
  @Column(name = "status", nullable = false)
  public DepositIntimatorStatus getStatus() {
    return status;
  }

  public void setStatus(final DepositIntimatorStatus status) {
    this.status = status;
  }

  @Enumerated
  @Column(name = "intimator_type", nullable = false)
  public DepositIntimatorType getDepositIntimatorType() {
    return depositIntimatorType;
  }

  public void setDepositIntimatorType(final DepositIntimatorType depositIntimatorType) {
    this.depositIntimatorType = depositIntimatorType;
  }

  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @Column(name = "cash_deposit_bank_name")
  public String getCashDepositedBankName() {
    return cashDepositedBankName;
  }

  public void setCashDepositedBankName(final String cashDepositedBankName) {
    this.cashDepositedBankName = cashDepositedBankName;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
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
    result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
    result = prime * result + (depositIntimatorType == null ? 0 : depositIntimatorType.hashCode());
    result = prime * result + (modeOfPayment == null ? 0 : modeOfPayment.hashCode());
    result = prime * result + (transactedDate == null ? 0 : transactedDate.hashCode());
    result = prime * result + (userByUserId == null ? 0 : userByUserId.hashCode());
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
    DepositIntimator other = (DepositIntimator) obj;
    if (createdAt == null) {
      if (other.createdAt != null) {
        return false;
      }
    } else if (!createdAt.equals(other.createdAt)) {
      return false;
    }
    if (depositIntimatorType != other.depositIntimatorType) {
      return false;
    }
    if (modeOfPayment != other.modeOfPayment) {
      return false;
    }
    if (transactedDate == null) {
      if (other.transactedDate != null) {
        return false;
      }
    } else if (!transactedDate.equals(other.transactedDate)) {
      return false;
    }
    if (userByUserId == null) {
      if (other.userByUserId != null) {
        return false;
      }
    } else if (!userByUserId.equals(other.userByUserId)) {
      return false;
    }
    return true;
  }

}
