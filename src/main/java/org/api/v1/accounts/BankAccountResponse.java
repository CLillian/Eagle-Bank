package org.api.v1.accounts;

import lombok.Data;
import org.datamodels.Account;
import org.datamodels.AccountType;
import org.datamodels.SortCode;

@Data
public class BankAccountResponse {
  private final String accountNumber;
  private final SortCode sortCode;
  private final String name;
  private final AccountType accountType;
  private final Double balance;
  private final String currency;
  private final String createdTimestamp;
  private final String updatedTimestamp;
  
  public BankAccountResponse(Account account) {
    this.accountNumber = account.getAccountNumber();
    this.sortCode = account.getSortCode();
    this.name = account.getName();
    this.accountType = account.getAccountType();
    this.balance = account.getBalance();
    this.currency = account.getCurrency().toString();
    this.createdTimestamp = account.getCreatedTimestamp();
    this.updatedTimestamp = account.getUpdatedTimestamp();
  }
}
