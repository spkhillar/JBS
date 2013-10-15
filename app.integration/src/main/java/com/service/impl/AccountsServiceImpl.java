package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.entities.Accounts;
import com.jpa.repositories.AccountsDAO;
import com.service.AccountsService;
import com.service.util.ServiceUtil;

@Service("accountsService")
public class AccountsServiceImpl implements AccountsService {

  @Autowired
  private AccountsDAO accountsDAO;

  @Override
  public Accounts save(Accounts accounts) {
    return accountsDAO.save(accounts);
  }

  @Override
  public Page<Accounts> findAll(int page, int rows, String sord, String sidx) {
    Pageable pageable = ServiceUtil.getPage(page, rows, sord, sidx);
    return accountsDAO.findAll(pageable);
  }

}
