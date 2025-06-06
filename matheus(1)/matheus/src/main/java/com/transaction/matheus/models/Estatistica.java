package com.transaction.matheus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estatistica {
  private int count;

  private double sum;

  private double avg;

  private double min;

  private double max;
}
