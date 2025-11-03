package org.dao.users;

import org.datamodels.Address;
import org.datamodels.User;

public interface UserDAO {
  
  User makeNewUser(String name, Address address, String phoneNumber, String email);
}
