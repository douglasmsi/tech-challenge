package br.com.fiap.postech.fastfood.usecases.pagamento.impl;

import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pagamento.CriarPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarPagamentoUseCaseImpl implements CriarPagamentoUseCase {
  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento save(Pagamento pagamento) {
    return pagamentoPersistencePort.save(pagamento);
  }
}
