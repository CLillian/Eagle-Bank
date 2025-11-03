package org.datamodels;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {

  private final String line1;
  private final String line2;
  private final String line3;
  private final String town;
  private final String county;
  private final String postcode;
}
