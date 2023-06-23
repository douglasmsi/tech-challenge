package br.com.fiap.postech.fastfood.core.services.pagamento;

import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PagamentoServicePortImpl implements PagamentoServicePort {

  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento save(final Pagamento pagamento) {
    return pagamentoPersistencePort.save(pagamento);
  }

  @Override
  public Pagamento findById(final Long id) {
    return pagamentoPersistencePort.findById(id);
  }

  @Override
  public Pagamento updateStatusPagamento(final Pagamento pagamento) {
    return pagamentoPersistencePort.updateStatusPagamento(pagamento);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoPersistencePort.findAll();
  }

  @Override
  public List<Pagamento> findAllByStatus(final PagamentoStatus status) {
    return pagamentoPersistencePort.findAllByStatus(status);
  }
}
