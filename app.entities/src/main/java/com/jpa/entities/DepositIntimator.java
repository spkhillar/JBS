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
 * DepositIntimator
 */
@Entity
@Table(name = "deposit_intimator")
public class DepositIntimator implements BaseEntity, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6027320354612393779L;
  private long id;
  private int version;
  private User userByUserId;
  private User userByReceiverUserId;
  private BigDecimal amountDeposited;
  private Date transactedDate;
  private String modeOfPayment;
  private Long transactionNumber;
  private byte[] receiptCopy;
  private String chequeNumber;
  private Date chequeDate;
  private String chequeDrawnOnBank;
  private String chequeDrawnBranch;
  private String status;
  private Date createdAt;
  private Date updatedAt;

  public DepositIntimator() {
  }

  public DepositIntimator(long id, User userByUserId,
      BigDecimal amountDeposited, Date transactedDate,
      String modeOfPayment, String status, Date createdAt, Date updatedAt) {
    this.id = id;
    this.userByUserId = userByUserId;
    this.amountDeposited = amountDeposited;
    this.transactedDate = transactedDate;
    this.modeOfPayment = modeOfPayment;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public DepositIntimator(long id, User userByUserId,
      User userByReceiverUserId, BigDecimal amountDeposited,
      Date transactedDate, String modeOfPayment, Long transactionNumber,
      byte[] receiptCopy, String chequeNumber, Date chequeDate,
      String chequeDrawnOnBank, String chequeDrawnBranch, String status,
      Date createdAt, Date updatedAt) {
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
  public User getUserByUserId() {
    return this.userByUserId;
  }

  public void setUserByUserId(User userByUserId) {
    this.userByUserId = userByUserId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "receiver_user_id")
  public User getUserByReceiverUserId() {
    return this.userByReceiverUserId;
  }

  public void setUserByReceiverUserId(User userByReceiverUserId) {
    this.userByReceiverUserId = userByReceiverUserId;
  }

  @Column(name = "amount_deposited", nullable = false, precision = 10)
  public BigDecimal getAmountDeposited() {
    return this.amountDeposited;
  }

  public void setAmountDeposited(BigDecimal amountDeposited) {
    this.amountDeposited = amountDeposited;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "transacted_date", nullable = false, length = 19)
  public Date getTransactedDate() {
    return this.transactedDate;
  }

  public void setTransactedDate(Date transactedDate) {
    this.transactedDate = transactedDate;
  }

  @Column(name = "mode_of_payment", nullable = false, length = 50)
  public String getModeOfPayment() {
    return this.modeOfPayment;
  }

  public void setModeOfPayment(String modeOfPayment) {
    this.modeOfPayment = modeOfPayment;
  }

  @Column(name = "transaction_number")
  public Long getTransactionNumber() {
    return this.transactionNumber;
  }

  public void setTransactionNumber(Long transactionNumber) {
    this.transactionNumber = transactionNumber;
  }

  @Column(name = "receipt_copy")
  public byte[] getReceiptCopy() {
    return this.receiptCopy;
  }

  public void setReceiptCopy(byte[] receiptCopy) {
    this.receiptCopy = receiptCopy;
  }

  @Column(name = "cheque_number", length = 50)
  public String getChequeNumber() {
    return this.chequeNumber;
  }

  public void setChequeNumber(String chequeNumber) {
    this.chequeNumber = chequeNumber;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "cheque_date", length = 10)
  public Date getChequeDate() {
    return this.chequeDate;
  }

  public void setChequeDate(Date chequeDate) {
    this.chequeDate = chequeDate;
  }

  @Column(name = "cheque_drawn_on_bank", length = 100)
  public String getChequeDrawnOnBank() {
    return this.chequeDrawnOnBank;
  }

  public void setChequeDrawnOnBank(String chequeDrawnOnBank) {
    this.chequeDrawnOnBank = chequeDrawnOnBank;
  }

  @Column(name = "cheque_drawn_branch", length = 100)
  public String getChequeDrawnBranch() {
    return this.chequeDrawnBranch;
  }

  public void setChequeDrawnBranch(String chequeDrawnBranch) {
    this.chequeDrawnBranch = chequeDrawnBranch;
  }

  @Column(name = "status", nullable = false, length = 100)
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
