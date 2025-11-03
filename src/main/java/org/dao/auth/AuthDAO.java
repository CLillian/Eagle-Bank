package org.dao.auth;

public interface AuthDAO {
  String getUserIdFromCredentials(String username, String password);
}
