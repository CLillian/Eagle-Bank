package org.api.v1.accounts.request;

import io.vertx.ext.web.RoutingContext;
import org.api.v1.accounts.request.body.CreateAccountBody;
import org.datamodels.AccountType;
import org.api.v1.accounts.BankAccountResponse;
import org.dao.accounts.AccountDAO;
import org.datamodels.Account;

public class CreateAccountRequest {
  
  private final RoutingContext routingContext;
  private final CreateAccountBody createAccountBody;
  private final AccountDAO accountDAO;
  
  public CreateAccountRequest(RoutingContext routingContext, CreateAccountBody body, AccountDAO accountDAO) {
    this.routingContext = routingContext;
    this.createAccountBody = body;
    this.accountDAO = accountDAO;
  }
  
  public void getResponse() {
    // given the body, act on the request and set the response data on the routing context
    
    if (createAccountBody.getName() == null) {
      // error case
    }
    
    if (!createAccountBody.getAccountType().equals(AccountType.PERSONAL)) {
      // error case
    }
    
    // success case - add the account
    Account newAccount = this.accountDAO.createNewAccount();
    
    
    BankAccountResponse bankAccountResponse = new BankAccountResponse(newAccount);
  }
  
}
