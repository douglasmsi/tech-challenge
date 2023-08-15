package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;

public interface CriarPagamentoUseCase {
  Pagamento save(Pagamento pagamento);
}


