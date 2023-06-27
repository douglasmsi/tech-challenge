package br.com.fiap.postech.fastfood.core.ports.pagamento;

import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import java.util.List;

public interface PagamentoServicePort {

  Pagamento save(Pagamento pagamento);
  Pagamento findById(Long id);


  Pagamento updateStatusPagamento(Pagamento pagamento);

  PagamentoStatus getStatusPagamento(String numeroPedido);

  List<Pagamento> findAll();
  List<Pagamento> findAllByStatus(PagamentoStatus status);

}
