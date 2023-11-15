package br.com.fiap.postech.fastfood.controller.dto;

import br.com.fiap.postech.fastfood.domain.item.Item;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedidoRequest {

  private Item item;
  private Integer quantidade;

}
