package org.dao.users;

import org.datamodels.Address;
import org.datamodels.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAOMemory implements UserDAO {
  
  private static final AtomicInteger lastGeneratedUserId = new AtomicInteger(0);
  public List<User> existingUsers = new ArrayList<>();
  
  @Override
  public User makeNewUser(String name, Address address, String phoneNumber, String email) {
    String userId = makeAndFormatUserId();
    
    // get unix timstamp
    long unixTimeNow = System.currentTimeMillis() / 1000;
    
    User user = new User(userId, name, address, phoneNumber, email, unixTimeNow, unixTimeNow);
    
    existingUsers.add(user);
    
    return user;
  }
  
  private String makeAndFormatUserId() {
    return String.format("%08d", lastGeneratedUserId.incrementAndGet());
  }
}
