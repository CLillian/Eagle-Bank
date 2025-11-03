package org.api.v1.routers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.body.CreateAccountBody;
import org.api.v1.endpoints.UserEndpoints;
import org.api.v1.users.request.body.CreateUserRequestBody;

public class UserV1Router extends RouterBase {
  
  private final Router subRouter;
  private final UserEndpoints userEndpoints;
  
  public UserV1Router(Router subRouter, UserEndpoints userEndpoints) {
    this.subRouter = subRouter;
    this.userEndpoints = userEndpoints;
  }
  
  public Router deployHandler() {
    subRouter.post("/").blockingHandler(this::createUser);
    
    return subRouter;
  }
  
  private void createUser(RoutingContext routingContext) {
    CreateUserRequestBody body = bodyAs(routingContext, CreateUserRequestBody.class);
    
    this.userEndpoints.createUser(routingContext, body);
  }
}
