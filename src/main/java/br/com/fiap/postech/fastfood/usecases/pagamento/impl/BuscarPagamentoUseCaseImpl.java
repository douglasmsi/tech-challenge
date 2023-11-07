package br.com.fiap.postech.fastfood.usecases.pagamento.impl;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pagamento.BuscarPagamentoUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuscarPagamentoUseCaseImpl implements BuscarPagamentoUseCase {
  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento findById(Long id) {
    return pagamentoPersistencePort.findById(id);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoPersistencePort.findAll();
  }

  @Override
  public List<Pagamento> findAllByStatus(PagamentoStatus status) {
    return pagamentoPersistencePort.findAllByStatus(status);
  }

  @Override
  public PagamentoStatus getStatusPagamento(String numeroPedido) {
    return pagamentoPersistencePort.getStatusPagamento(numeroPedido);
  }
}
