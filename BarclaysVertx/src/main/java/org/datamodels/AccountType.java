package org.datamodels;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountType {
  PERSONAL("personal");
  
  private final String accountTypeString;
}
