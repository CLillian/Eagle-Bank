package org.dao;

import org.dao.accounts.AccountDAO;
import org.dao.accounts.AccountDAOMemory;

public class ProductionDAOs {
  
  private static AccountDAO accountDAO = new AccountDAOMemory();
  
  public static AccountDAO getAccountDAO() {
    return accountDAO;
  }
}
