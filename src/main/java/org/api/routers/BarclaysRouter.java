package org.api.routers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.api.v1.endpoints.AccountEndpoints;
import org.api.v1.routers.AccountV1Router;
import org.api.v1.routers.UserV1Router;

public class BarclaysRouter {

  public Router create(Vertx vertx) throws Exception {
    Router router = Router.router(vertx);
    
    io.vertx.ext.web.Router accountV1SubRouter = io.vertx.ext.web.Router.router(vertx);
    AccountV1Router accountV1Router =
        new AccountV1Router(accountV1SubRouter, new AccountEndpoints());
    router.route("/v1/accounts*").subRouter(accountV1Router.deployHandler());
    
    io.vertx.ext.web.Router userV1SubRouter = io.vertx.ext.web.Router.router(vertx);
    UserV1Router userV1Router =
        new UserV1Router(userV1SubRouter, new UserEndpoints());
    router.route("/v1/users*").subRouter(userV1Router.deployHandler());

    return router;
  }
}
