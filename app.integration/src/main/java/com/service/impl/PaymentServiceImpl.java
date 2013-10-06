package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.Payment;
import com.jpa.repositories.PaymentDAO;
import com.service.PaymentService;
import com.service.util.ServiceUtil;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentDAO paymentDAO;

  @Override
  @Transactional(readOnly = true)
  public Page<Payment> findAll(final int page, final int rows, final String sord, final String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return paymentDAO.findAll(pageable);
  }

  @Override
  @Transactional()
  public Payment save(Payment payment) {
    return paymentDAO.save(payment);
  }

  @Override
  @Transactional(readOnly = true)
  public Payment findById(long id) {
    return paymentDAO.findOne(id);
  }

  @Override
  @Transactional
  public Payment updatePaymentDate(long id) {
    Payment payment = findById(id);
    payment.setPaymentDate(new Date());
    payment.setUpdatedAt(new Date());
    return paymentDAO.save(payment);
  }

}
