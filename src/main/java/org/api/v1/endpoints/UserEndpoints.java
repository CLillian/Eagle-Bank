package org.api.v1.endpoints;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.CreateAccountRequest;
import org.api.v1.accounts.request.ListAccountsRequest;
import org.api.v1.accounts.request.body.CreateAccountBody;
import org.api.v1.users.request.CreateUserRequest;
import org.api.v1.users.request.body.CreateUserRequestBody;
import org.dao.ProductionDAOs;

public class UserEndpoints {
  
  public void createUser(RoutingContext routingContext,
      final CreateUserRequestBody body) {
    CreateUserRequest createUserRequest = new CreateUserRequest(routingContext, body,
        ProductionDAOs.getUserDAO());
    
    createUserRequest.processRequest();
  }

}
