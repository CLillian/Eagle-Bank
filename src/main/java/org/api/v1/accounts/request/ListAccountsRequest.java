package org.api.v1.accounts.request;

import io.vertx.ext.web.RoutingContext;
import org.dao.accounts.AccountDAO;
import org.utils.JWTUtils;

public class ListAccountsRequest {
  
  private final RoutingContext routingContext;
  private final AccountDAO accountDAO;
  
  public ListAccountsRequest(RoutingContext routingContext, AccountDAO accountDAO) {
    this.routingContext = routingContext;
    this.accountDAO = accountDAO;
  }
  
  public void getResponse() {
    String authToken = routingContext.request().getHeader("Authorization");
    String userId = JWTUtils.getUserIdFromJWT(authToken);
    
    
  }
}
