package org.api.v1.users.request;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.CreateAccountRequest;
import org.api.v1.users.request.body.CreateUserRequestBody;
import org.dao.users.UserDAO;

public class CreateUserRequest {
  
  private final RoutingContext routingContext;
  private final CreateUserRequestBody createUserRequestBody;
  private final UserDAO userDAO;
  
  public CreateUserRequest(RoutingContext routingContext, CreateUserRequestBody body,
      UserDAO userDAO) {
    this.routingContext = routingContext;
    this.createUserRequestBody = body;
    this.userDAO = userDAO;
  }
  
  public void getResponse() {
  
  }
}
