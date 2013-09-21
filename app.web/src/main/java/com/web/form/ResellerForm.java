package com.web.form;

import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.DepositIntimator;

public class ResellerForm {

  private DepositIntimator depositIntimator;

  private MultipartFile cashReceipt;

  private String paymentMode;

  private String receiverResellerId;

  public ResellerForm() {
    initializeResellerForm();
  }

  public ResellerForm(DepositIntimator depositIntimator) {
    super();
    this.depositIntimator = depositIntimator;
  }

  private void initializeResellerForm() {
    depositIntimator = new DepositIntimator();
  }

  public DepositIntimator getDepositIntimator() {
    return depositIntimator;
  }

  public void setDepositIntimator(DepositIntimator depositIntimator) {
    this.depositIntimator = depositIntimator;
  }

  public MultipartFile getCashReceipt() {
    return cashReceipt;
  }

  public void setCashReceipt(MultipartFile cashReceipt) {
    this.cashReceipt = cashReceipt;
  }

  public String getPaymentMode() {
    return paymentMode;
  }

  public void setPaymentMode(String paymentMode) {
    this.paymentMode = paymentMode;
  }

  public String getReceiverResellerId() {
    return receiverResellerId;
  }

  public void setReceiverResellerId(String receiverResellerId) {
    this.receiverResellerId = receiverResellerId;
  }

}
