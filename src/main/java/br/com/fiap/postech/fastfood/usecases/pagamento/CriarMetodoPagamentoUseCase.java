package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;

public interface CriarMetodoPagamentoUseCase {
  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);
}

