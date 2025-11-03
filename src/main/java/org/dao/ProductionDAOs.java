package org.dao;

import org.dao.accounts.AccountDAO;
import org.dao.accounts.AccountDAOMemory;
import org.dao.auth.AuthDAO;
import org.dao.auth.AuthDAOMemory;
import org.dao.users.UserDAO;
import org.dao.users.UserDAOMemory;
import org.datamodels.User;

public class ProductionDAOs {
  
  private static AccountDAO accountDAO = new AccountDAOMemory();
  private static UserDAO userDAO = new UserDAOMemory();
  private static AuthDAO authDAO = new AuthDAOMemory();
  
  public static AccountDAO getAccountDAO() {
    return accountDAO;
  }
  
  public static UserDAO getUserDAO() {
    return userDAO;
  }
  
  public static AuthDAO getAuthDAO() {
    return authDAO;
  }
}
