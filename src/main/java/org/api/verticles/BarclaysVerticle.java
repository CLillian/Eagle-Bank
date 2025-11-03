package org.api.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.api.routers.BarclaysRouter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BarclaysVerticle extends AbstractVerticle {

  /**
   * The port on which the server listens
   */
  public static final int PORT = 8080;

  private final Router router;

  public static class Factory {
    private final Router router;

    public Factory(Vertx vertx, BarclaysRouter router) throws Exception {
      this.router = router.create(vertx);
    }

    public BarclaysVerticle create() {
      return new BarclaysVerticle(router);
    }
  }

  @Override
  public void start() {

    // Create the HTTP server
    vertx.createHttpServer()
        // Handle every request using the router
        .requestHandler(router)
        // Start listening
        .listen(PORT)
        // Print the port on success
        .onSuccess(server -> {
          System.out.println("HTTP server started on port " + server.actualPort());
        })
        // Print the problem on failure
        .onFailure(throwable -> {
          throwable.printStackTrace();
        });
  }
}
