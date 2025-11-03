package org.api.v1.routers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.DecodeException;
import io.vertx.ext.web.RoutingContext;

public class RouterBase {
  
  /**
   * Object mapper for deserialising body JSON
   */
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  
  protected <T> T bodyAs(RoutingContext routingContext, Class<T> clazz) {
    if (routingContext.body().asString() == null) {
      return null;
    }
    try {
      return OBJECT_MAPPER.readValue(routingContext.body().asString(), clazz);
    } catch (Exception ex) {
      throw new DecodeException("Failed to decode:" + ex.getMessage(), ex);
    }
  }
}
