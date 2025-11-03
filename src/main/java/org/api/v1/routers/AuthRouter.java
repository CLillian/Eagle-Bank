package org.api.v1.routers;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.api.v1.auth.request.body.AuthRequestBody;
import org.api.v1.endpoints.AuthEndpoints;
import org.api.v1.endpoints.UserEndpoints;
import org.api.v1.users.request.body.CreateUserRequestBody;

public class AuthRouter extends RouterBase {
  
  private final Router subRouter;
  private final AuthEndpoints authEndpoints;
  
  public AuthRouter(Router subRouter, AuthEndpoints authEndpoints) {
    this.subRouter = subRouter;
    this.authEndpoints = authEndpoints;
  }
  
  public Router deployHandler() {
    subRouter.get("/").blockingHandler(this::authenticateLogin);
    
    return subRouter;
  }
  
  private void authenticateLogin(RoutingContext routingContext) {
    AuthRequestBody body = bodyAs(routingContext, AuthRequestBody.class);
    
    this.authEndpoints.authenticateUser(routingContext, body);
  }
}
