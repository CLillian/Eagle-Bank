package org.api.v1.accounts.request;

import io.vertx.ext.web.RoutingContext;

public class ListAccountsRequest {
  
  private final RoutingContext routingContext;
  
  public void getResponse() {
    
    String authToken = routingContext.request().getHeader("Authorization");
    
    
  }
}
