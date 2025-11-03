package org.datamodels;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortCode {
  STANDARD("10-10-10");
  
  private final String sortCodeString;
}
