package br.com.fiap.postech.fastfood.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CriarPedidoRequest {

  private String clienteCpf;

}
