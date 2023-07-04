package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CriarCheckoutRequest {

  private String cpf;
  private Long metodoPagamentoId;
  private BigDecimal valor;

}
