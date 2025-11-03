package org.api.v1.endpoints;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.auth.request.AuthRequest;
import org.api.v1.auth.request.body.AuthRequestBody;
import org.dao.ProductionDAOs;

public class AuthEndpoints {
  
  public void authenticateUser(RoutingContext routingContext,
      final AuthRequestBody body) {
    AuthRequest authRequest = new AuthRequest(routingContext, body,
        ProductionDAOs.getAuthDAO());
    
    authRequest.processRequest();
  }
}
