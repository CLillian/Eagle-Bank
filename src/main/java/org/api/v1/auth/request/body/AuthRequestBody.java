package org.api.v1.auth.request.body;

import lombok.Data;

@Data
public class AuthRequestBody {
  
  private final String username;
  private final String password;
}
