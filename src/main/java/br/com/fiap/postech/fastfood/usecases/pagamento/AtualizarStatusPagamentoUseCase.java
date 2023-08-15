package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;

public interface AtualizarStatusPagamentoUseCase {
  Pagamento updateStatusPagamento(Pagamento pagamento);
}

