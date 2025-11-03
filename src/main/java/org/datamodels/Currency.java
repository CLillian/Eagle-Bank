package org.datamodels;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Currency {
  GBP("GBP");
  
  private final String currencyString;
  
  @Override
  public String toString() {
    return currencyString;
  }
}
