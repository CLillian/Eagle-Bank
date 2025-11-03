package org.datamodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;

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
    
    private long createdUnixTime;
    private long updatedUnixTime;
    
    public String getCreatedTimestamp() {
        return convertUnixTimeSecondsToString(createdUnixTime);
    }
    
    public String getUpdatedTimestamp() {
        return convertUnixTimeSecondsToString(updatedUnixTime);
    }
    
    private String convertUnixTimeSecondsToString(long unixTimeSeconds) {
        return Instant.ofEpochSecond(unixTimeSeconds)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
            .toString();
    }
}
