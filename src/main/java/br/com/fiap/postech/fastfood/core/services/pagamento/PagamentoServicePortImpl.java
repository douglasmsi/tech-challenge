package br.com.fiap.postech.fastfood.core.services.pagamento;

import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PagamentoServicePortImpl implements PagamentoServicePort {

  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento save(Pagamento pagamento) {
    return pagamentoPersistencePort.save(pagamento);
  }

  @Override
  public Pagamento findById(Long id) {
    return pagamentoPersistencePort.findById(id);
  }

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    return pagamentoPersistencePort.updateStatusPagamento(pagamento);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoPersistencePort.findAll();
  }

  @Override
  public List<Pagamento> findAllByStatus(PagamentoStatus status) {
    return pagamentoPersistencePort.findAllByStatus(status);
  }
}
