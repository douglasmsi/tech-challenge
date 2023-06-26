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
  private String numeroCartao;
  private String dataExpiracao;
  private String cvv;
  private BigDecimal valorTotal;

}
