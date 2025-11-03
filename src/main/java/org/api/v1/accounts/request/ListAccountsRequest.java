package org.api.v1.accounts.request;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.RequestBase;
import org.dao.accounts.AccountDAO;
import org.utils.JWTUtils;

public class ListAccountsRequest extends RequestBase {
  
  private final AccountDAO accountDAO;
  
  public ListAccountsRequest(RoutingContext routingContext, AccountDAO accountDAO) {
    super(routingContext);
    this.accountDAO = accountDAO;
  }
  
  @Override
  public void processRequest() {
    String userId = getUser();
    
    // todo
  }
}
