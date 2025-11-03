package org.dao.auth;

public class AuthDAOMemory implements AuthDAO {
  
  @Override
  public String getUserIdFromCredentials(String username, String password) {
    // hardcoded username and passwords for now
    if (username.equals("test username") && password.equals("test password")) {
      return "12345";
    }
    
    return null;
  }
}
