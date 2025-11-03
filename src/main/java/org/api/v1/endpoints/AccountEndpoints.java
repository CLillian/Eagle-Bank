package org.api.v1.endpoints;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.ListAccountsRequest;
import org.api.v1.accounts.request.body.CreateAccountBody;
import org.api.v1.accounts.request.CreateAccountRequest;
import org.api.v1.accounts.request.ListAccountsRequest;
import org.dao.ProductionDAOs;

public class AccountEndpoints {
  
  public void createAccount(RoutingContext routingContext,
      final CreateAccountBody body) {
    CreateAccountRequest createAccountRequest = new CreateAccountRequest(routingContext, body,
        ProductionDAOs.getAccountDAO());
    
    createAccountRequest.processRequest();
  }
  
  public void listAccounts(RoutingContext routingContext) {
    ListAccountsRequest listAccountsRequest = new ListAccountsRequest(routingContext,
        ProductionDAOs.getAccountDAO());
    
    listAccountsRequest.processRequest();
  }

}
