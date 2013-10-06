package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long> {




}
