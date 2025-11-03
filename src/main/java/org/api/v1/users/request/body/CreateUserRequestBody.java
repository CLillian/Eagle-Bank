package org.api.v1.users.request.body;

import lombok.Data;
import org.datamodels.Address;

@Data
public class CreateUserRequestBody {

  private String name;
  private Address address;
  private String phoneNumber;
  private String email;

}
