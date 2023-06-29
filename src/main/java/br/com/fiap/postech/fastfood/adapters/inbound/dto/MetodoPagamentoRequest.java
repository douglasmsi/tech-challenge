package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
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
