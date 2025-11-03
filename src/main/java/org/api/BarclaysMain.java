package org.api;

import io.vertx.core.Vertx;
import org.api.routers.BarclaysRouter;
import org.api.verticles.BarclaysVerticle;

public class BarclaysMain {
  public static void main(String[] args) throws Exception {
    Vertx vertx = Vertx.vertx();

    BarclaysVerticle.Factory barclaysFactory = new BarclaysVerticle.Factory(vertx,
        new BarclaysRouter());

    vertx.deployVerticle(barclaysFactory.create());
  }
}
