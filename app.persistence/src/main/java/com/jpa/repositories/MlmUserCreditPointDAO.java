package com.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.enums.MlmUserCreditPointStatus;

public interface MlmUserCreditPointDAO extends JpaRepository<MlmUserCreditPoint, Long> {

  public List<MlmUserCreditPoint> findByMlmUserCreditPointStatus(MlmUserCreditPointStatus mlmUserCreditPointStatus);



}
