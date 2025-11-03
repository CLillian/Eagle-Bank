package org.api.v1.users.response;

import lombok.Data;
import org.datamodels.Address;
import org.datamodels.User;

@Data
public class CreateUserResponse {

  private final String id;
  private final String name;
  private final Address address;
  private final String phoneNumber;
  private final String email;
  private final String createdTimestamp;
  private final String updatedTimestamp;
  
  public CreateUserResponse(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.address = user.getAddress();
    this.phoneNumber = user.getPhoneNumber();
    this.email = user.getEmail();
    
    // convert the user's created unix timestamp into a timestamp
    
  }
}
