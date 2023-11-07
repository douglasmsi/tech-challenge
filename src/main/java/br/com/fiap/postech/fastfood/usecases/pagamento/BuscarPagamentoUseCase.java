package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;

import java.util.List;

public interface BuscarPagamentoUseCase {
  Pagamento findById(Long id);
  List<Pagamento> findAll();
  List<Pagamento> findAllByStatus(PagamentoStatus status);
  PagamentoStatus getStatusPagamento(String numeroPedido);
}
