package br.com.fiap.postech.fastfood.usecases.pagamento.impl;

import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pagamento.CriarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarMetodoPagamentoUseCaseImpl implements CriarMetodoPagamentoUseCase {
  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento) {
    return metodoPagamentoPersistencePort.createMetodoPagamento(metodoPagamento);
  }
}

