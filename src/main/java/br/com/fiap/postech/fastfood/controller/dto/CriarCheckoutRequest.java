package br.com.fiap.postech.fastfood.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CriarCheckoutRequest {

  private String cpf;
  private Long metodoPagamentoId;
  private BigDecimal valor;

}
