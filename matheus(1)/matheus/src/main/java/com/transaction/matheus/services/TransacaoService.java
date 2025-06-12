package com.transaction.matheus.services;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transaction.matheus.models.Estatistica;
import com.transaction.matheus.models.Transacao;

@Service
public class TransacaoService {

  private final List<Transacao> transacoes = new ArrayList<>();

  public void addTransacao(Transacao transacao) {
    if (transacao.getValor() < 0) {
      throw new IllegalArgumentException("O valor da transação não pode ser negativo");
    }
    if (transacao.getDataHora() == null) {
      throw new IllegalArgumentException("A data não pode ser nula");
    }
    if (transacao.getDataHora().isAfter(OffsetDateTime.now(ZoneOffset.of("-03:00")))) {
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

  public Estatistica calcularEstatistica() {
    OffsetDateTime agora = OffsetDateTime.now();
    OffsetDateTime limite = agora.minusSeconds(60);

    DoubleSummaryStatistics stats = transacoes.stream()
        .filter(t -> t.getDataHora().isAfter(limite))
        .mapToDouble(Transacao::getValor)
        .summaryStatistics();

    if (stats.getCount() == 0) {
      return new Estatistica(0, 0.0, 0.0, 0.0, 0.0);
    }

    return new Estatistica(
        (int) stats.getCount(),
        stats.getSum(),
        stats.getAverage(),
        stats.getMin(),
        stats.getMax());
  }
}
