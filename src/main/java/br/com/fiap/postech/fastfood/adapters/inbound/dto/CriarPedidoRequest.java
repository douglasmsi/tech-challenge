package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CriarPedidoRequest {

  private String clienteCpf;

}
