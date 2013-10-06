package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.Payment;

public interface PaymentService {

  public Payment save(Payment payment);

  public Page<Payment> findAll(int page, int rows, String sord, String sidx);

  public Payment findById(long id);

  public Payment updatePaymentDate(long id);
}
