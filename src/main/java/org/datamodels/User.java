package org.datamodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;

@AllArgsConstructor
@Getter
public class User {
  
  private String id;
  private String name;
  private Address address;
  private String phoneNumber;
  private String email;
  
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
