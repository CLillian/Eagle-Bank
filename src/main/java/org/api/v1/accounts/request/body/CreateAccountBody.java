package org.api.v1.accounts.request.body;

import lombok.Data;
import org.datamodels.AccountType;

@Data
public class CreateAccountBody {
  
  private final String name;
  private final AccountType accountType;
}
