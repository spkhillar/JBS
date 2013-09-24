package com.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.enums.DepositIntimatorStatus;

public interface DepositIntimatorDAO extends JpaRepository<DepositIntimator, Long> {

  public Page<DepositIntimator> findByStatus(DepositIntimatorStatus status, Pageable pageable);

}
