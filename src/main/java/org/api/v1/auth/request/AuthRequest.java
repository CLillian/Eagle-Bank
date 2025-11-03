package org.api.v1.auth.request;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.auth.request.body.AuthRequestBody;
import org.dao.auth.AuthDAO;
import org.utils.JWTUtils;

public class AuthRequest {
  
  private final RoutingContext routingContext;
  private final AuthRequestBody authRequestBody;
  private final AuthDAO authDAO;
  
  public AuthRequest(RoutingContext routingContext, AuthRequestBody authRequestBody,
      AuthDAO authDAO) {
    this.routingContext = routingContext;
    this.authRequestBody = authRequestBody;
    this.authDAO = authDAO;
  }
  
  public void getResponse() {
    String username = authRequestBody.getUsername();
    String password = authRequestBody.getPassword();
    
    String userId = authDAO.getUserIdFromCredentials(username, password);
    
    if (userId == null) {
      // todo handle error where user isn't authenticated
    }
    
    // generate a json web token with the userId as a permission
    String jwtToken = JWTUtils.generateToken(userId);
    
    // set the JWT in the response
    this.routingContext.response().putHeader("Authorization", jwtToken);
  }
}
