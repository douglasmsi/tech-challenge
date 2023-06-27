package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MetodoPagamentoRequest {

  private String cpf;
  private MetodoPagamento metodoPagamento;
}
