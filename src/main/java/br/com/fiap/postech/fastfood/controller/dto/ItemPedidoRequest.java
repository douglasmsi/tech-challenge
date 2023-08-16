package br.com.fiap.postech.fastfood.controller.dto;

import br.com.fiap.postech.fastfood.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemPedidoRequest {

  private Item item;
  private Integer quantidade;

}
