package br.com.fiap.postech.fastfood.usecases.pagamento.impl;

import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pagamento.AtualizarStatusPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarStatusPagamentoUseCaseImpl implements AtualizarStatusPagamentoUseCase {
  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    return pagamentoPersistencePort.updateStatusPagamento(pagamento);
  }
}
