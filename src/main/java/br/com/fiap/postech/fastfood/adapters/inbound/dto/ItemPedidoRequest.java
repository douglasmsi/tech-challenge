package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import br.com.fiap.postech.fastfood.core.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemPedidoRequest {

  private Item item;
  private Integer quantidade;


}
