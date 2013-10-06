package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.Payment;

public interface PaymentService {

  public Page<Payment> findAll(int page, int rows, String sord, String sidx);

}
