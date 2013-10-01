package com.service;

import java.util.List;

import com.jpa.entities.DepositIntimator;
import com.jpa.entities.MlmUserCreditPoint;
import com.jpa.entities.User;
import com.jpa.entities.enums.DepositIntimatorStatus;
import com.jpa.entities.enums.MlmUserCreditPointStatus;

public interface MlmUserCreditPointService {

  public void save(DepositIntimator depositIntimator);

  public long getUserPointCount(User user);

  public List<MlmUserCreditPoint> findByMlmUserCreditPointStatus(MlmUserCreditPointStatus mlmUserCreditPointStatus);

  public void updateStatus(MlmUserCreditPoint mlmUserCreditPoint, MlmUserCreditPointStatus mlmUserCreditPointStatus);

  public List<MlmUserCreditPoint> listMlmUserCreditPoint(User user, MlmUserCreditPointStatus mlmUserCreditPointStatus,
      DepositIntimatorStatus depositIntimatorStatus);

}
