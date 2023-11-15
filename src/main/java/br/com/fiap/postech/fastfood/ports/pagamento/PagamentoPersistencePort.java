package br.com.fiap.postech.fastfood.ports.pagamento;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;

import java.util.List;

public interface PagamentoPersistencePort {

  Pagamento save(Pagamento pagamento);
  Pagamento findById(Long id);
  Pagamento updateStatusPagamento(Pagamento pagamento);
  List<Pagamento> findAll();
  List<Pagamento> findAllByStatus(PagamentoStatus status);
  PagamentoStatus getStatusPagamento(String numeroPedido);
}
