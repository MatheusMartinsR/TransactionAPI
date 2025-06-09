package com.transaction.matheus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.matheus.models.Transacao;
import com.transaction.matheus.services.TransacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("transacao/")
public class TransacaoController {

  private final TransacaoService transacaoService;

  @Autowired
  public TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @PostMapping
  public ResponseEntity<Void> createTransaction(Transacao transacao) {
    try {
      transacaoService.addTransacao(transacao);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.unprocessableEntity().build();
    }
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteTransaction() {
    try {
      transacaoService.clearTransacao();
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.unprocessableEntity().build();
    }

  }

}
