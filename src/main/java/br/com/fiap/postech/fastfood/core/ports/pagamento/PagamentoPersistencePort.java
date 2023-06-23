package br.com.fiap.postech.fastfood.core.ports.pagamento;

import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;

import java.util.List;

public interface PagamentoPersistencePort {

  Pagamento save(final Pagamento pagamento);

  Pagamento findById(final Long id);

  Pagamento updateStatusPagamento(final Pagamento pagamento);

  List<Pagamento> findAll();

  List<Pagamento> findAllByStatus(final PagamentoStatus status);

}
