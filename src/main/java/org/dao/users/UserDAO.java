package org.dao.users;

import io.vertx.ext.auth.User;

public interface UserDAO {
  
  User makeNewUser();
}
