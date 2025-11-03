package org.api.v1.accounts.request;

import org.api.v1.accounts.request.body.CreateAccountBody;
import org.datamodels.AccountType;
import org.junit.jupiter.api.Test;

public class CreateAccountRequestTest {
  
  @Test
  public void nullNameInBodyTest() {
    // Given the body of the request to create an account doesn't have a name
    // When the request is processed
    // Then the return code should be Bad Request and a suitable error message displayed
    CreateAccountBody accountBody = new CreateAccountBody(null, AccountType.PERSONAL);
    
    //new CreateAccountRequest()
  }
}
