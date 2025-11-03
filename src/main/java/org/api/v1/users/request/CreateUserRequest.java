package org.api.v1.users.request;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import org.apache.http.entity.ContentType;
import org.api.v1.RequestBase;
import org.api.v1.users.request.body.CreateUserRequestBody;
import org.api.v1.users.response.CreateUserResponse;
import org.dao.users.UserDAO;
import org.datamodels.User;

public class CreateUserRequest extends RequestBase {
  
  private final CreateUserRequestBody createUserRequestBody;
  private final UserDAO userDAO;
  
  public CreateUserRequest(RoutingContext routingContext, CreateUserRequestBody body,
      UserDAO userDAO) {
    super(routingContext);
    this.createUserRequestBody = body;
    this.userDAO = userDAO;
  }
  
  @Override
  public void processRequest() {
    User user = this.userDAO.makeNewUser(createUserRequestBody.getName(),
        createUserRequestBody.getAddress(), createUserRequestBody.getPhoneNumber(),
        createUserRequestBody.getEmail());
    
    CreateUserResponse response = new CreateUserResponse(user);
    
    routingContext.response().putHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
    routingContext.response().end(Json.encodePrettily(response));
  }
}
