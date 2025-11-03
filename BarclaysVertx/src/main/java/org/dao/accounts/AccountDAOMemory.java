package org.dao.accounts;

import org.datamodels.AccountType;
import org.datamodels.Currency;
import org.datamodels.SortCode;
import org.datamodels.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountDAOMemory implements AccountDAO {
  
  private static final AtomicInteger lastGeneratedAccountNumber = new AtomicInteger(0);
  public List<Account> existingAccounts = new ArrayList<>();
  
  @Override
  public Account createNewAccount() {
    String newAccountNumber = makeAndFormatAccountNumber();
    
    String dateTimeString = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    
    Account newAccount =
        new Account(newAccountNumber, SortCode.STANDARD, "", AccountType.PERSONAL, 0, Currency.GBP,
            dateTimeString, dateTimeString);
    
    existingAccounts.add(newAccount);
    
    return newAccount;
  }
  
  private String makeAndFormatAccountNumber() {
    return String.format("%08d", lastGeneratedAccountNumber.incrementAndGet());
  }
}
