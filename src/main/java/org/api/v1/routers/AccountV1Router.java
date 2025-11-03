package org.api.v1.routers;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.body.CreateAccountBody;
import org.api.v1.endpoints.AccountEndpoints;

public class AccountV1Router extends  RouterBase {
  
  private final Router subRouter;
  private final AccountEndpoints accountEndpoints;
  
  public AccountV1Router(Router subRouter, AccountEndpoints accountEndpoints) {
    this.subRouter = subRouter;
    this.accountEndpoints = accountEndpoints;
  }
  
  public Router deployHandler() {
    subRouter.get("/").blockingHandler(this::listAccounts);
    
    subRouter.post("/").blockingHandler(this::createAccount);
    
    return subRouter;
  }
  
  private void createAccount(RoutingContext routingContext) {
    CreateAccountBody body = bodyAs(routingContext, CreateAccountBody.class);
  
    this.accountEndpoints.createAccount(routingContext, body);
  }
  
  private void listAccounts(RoutingContext routingContext) {
    this.accountEndpoints.listAccounts(routingContext);
  }
}
