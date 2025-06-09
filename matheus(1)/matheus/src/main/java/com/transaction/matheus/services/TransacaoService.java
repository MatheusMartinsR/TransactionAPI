package com.transaction.matheus.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transaction.matheus.models.Transacao;

@Service
public class TransacaoService {

  private final List<Transacao> transacoes = new ArrayList<>();

  public void addTransacao(Transacao transacao) {
    if (transacao.getValor() < 0) {
      throw new IllegalArgumentException("O valor da transação não pode ser negativo");
    }
    if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
      throw new IllegalArgumentException("A data não pode estar no futuro");
    }

    transacoes.add(transacao);
  }

  public List<Transacao> getTransacao() {
    return transacoes;
  }

  public void clearTransacao() {
    transacoes.clear();
  }

}
