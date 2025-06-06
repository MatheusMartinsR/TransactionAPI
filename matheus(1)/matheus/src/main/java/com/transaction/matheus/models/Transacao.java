package com.transaction.matheus.models;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

  private Double valor;

  private OffsetDateTime dataHora;

}
