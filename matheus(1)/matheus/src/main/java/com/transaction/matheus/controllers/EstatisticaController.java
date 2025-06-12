package com.transaction.matheus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.matheus.models.Estatistica;
import com.transaction.matheus.services.TransacaoService;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

  private final TransacaoService transacaoService;

  public EstatisticaController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @GetMapping
  public ResponseEntity<Estatistica> showEstatistics() {
    Estatistica estatistica = transacaoService.calcularEstatistica();
    return ResponseEntity.ok(estatistica);
  }

}
