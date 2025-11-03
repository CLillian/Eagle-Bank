package org.api.v1.users.response;

import lombok.Data;
import org.datamodels.Address;

@Data
public class CreateUserResponse {

  private final String id;
  private final String name;
  private final Address address;
  private final String phoneNumber;
  private final String email;
  private final String createdTimestamp;
  private final String updatedTimestamp;
}
