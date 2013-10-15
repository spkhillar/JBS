package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.Accounts;

public interface AccountsService {

  public Accounts save(Accounts accounts);

  public Page<Accounts> findAll(final int page, final int rows, final String sord, final String sidx);

}
