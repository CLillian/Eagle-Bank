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
  public Account createNewAccount(String userId, String accountName) {
    String newAccountNumber = makeAndFormatAccountNumber();
    
    // get unix timstamp
    long unixTimeNow = System.currentTimeMillis() / 1000;
    
    Account newAccount =
        new Account(userId, newAccountNumber, SortCode.STANDARD, accountName, AccountType.PERSONAL,
            0, Currency.GBP, unixTimeNow, unixTimeNow);
    
    existingAccounts.add(newAccount);
    
    return newAccount;
  }
  
  private String makeAndFormatAccountNumber() {
    return String.format("%08d", lastGeneratedAccountNumber.incrementAndGet());
  }
}
