package br.com.fiap.postech.fastfood.controller.dto;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MetodoPagamentoRequest {

  private MetodoPagamento metodoPagamento;
}
