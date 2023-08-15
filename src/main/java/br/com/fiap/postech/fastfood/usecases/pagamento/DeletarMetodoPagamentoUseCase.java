package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;

public interface DeletarMetodoPagamentoUseCase {
  MetodoPagamento deleteByIdAndCPF(Long id, String cpf);
}

