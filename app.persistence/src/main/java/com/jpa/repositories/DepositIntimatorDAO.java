package com.jpa.repositories;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;

public interface DepositIntimatorDAO extends JpaRepository<DepositIntimator, Long> {

  public Page<DepositIntimator> findByStatus(DepositIntimatorStatus status, Pageable pageable);

  public Page<DepositIntimator> findByUserByUserIdAndStatusIn(User userByUserId,
      Collection<DepositIntimatorStatus> status, Pageable pageable);

  public Page<DepositIntimator> findByUserByReceiverUserIdAndMemo(User userByReceiverUserId, String memo,
      Pageable pageable);
}
