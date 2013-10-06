package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.entities.Payment;
import com.jpa.repositories.PaymentDAO;
import com.service.PaymentService;
import com.service.util.ServiceUtil;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{

  @Autowired
  private PaymentDAO paymentDAO;

  @Override
  public Page<Payment> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return paymentDAO.findAll(pageable);
  }

}
