package org.api.v1.accounts.request;

import static org.junit.Assert.assertThat;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpMethod;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.api.routers.BarclaysRouter;
import org.api.verticles.BarclaysVerticle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

@ExtendWith(VertxExtension.class)
public class CreateAccountIntegrationTest {
  
  HttpClient client;
  
  Vertx vertx = Vertx.vertx();
  
  @Test
  public void http_server_check_response() throws Exception {
    VertxTestContext testContext = new VertxTestContext();
    
    BarclaysVerticle.Factory barclaysFactory = new BarclaysVerticle.Factory(vertx,
        new BarclaysRouter());
    vertx.deployVerticle(barclaysFactory.create()).onComplete(testContext.succeedingThenComplete());
    
    client = vertx.createHttpClient();
    client.request(HttpMethod.POST, 8080, "localhost", "/v1/accounts")
        .compose(req -> req.send().compose(HttpClientResponse::body))
        .onComplete(testContext.succeedingThenComplete());
  }
}
