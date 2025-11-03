package org.datamodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {
  
    private final String userId;
    
    private final String accountNumber;
    private final SortCode sortCode;
    private final String name;
    private final AccountType accountType;
    private final double balance;
    private final Currency currency;
    private final String createdTimestamp;
    private final String updatedTimestamp;
}
