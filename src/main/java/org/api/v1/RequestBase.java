package org.api.v1;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import org.apache.http.entity.ContentType;
import org.utils.JWTUtils;

public abstract class RequestBase {
  
  protected final RoutingContext routingContext;
  
  public RequestBase(RoutingContext routingContext) {
    this.routingContext = routingContext;
  }
  
  protected String getUser() {
    // get the user making the request
    String authToken = routingContext.request().getHeader("Authorization");
    return JWTUtils.getUserIdFromJWT(authToken);
  }
  
  protected void setBodyResponse(Object json) {
    routingContext.response().putHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
    routingContext.response().end(Json.encodePrettily(json));
  }
  
  public abstract void processRequest();
}
