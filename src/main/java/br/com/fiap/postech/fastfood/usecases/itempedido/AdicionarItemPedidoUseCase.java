package br.com.fiap.postech.fastfood.usecases.itempedido;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;

public interface AdicionarItemPedidoUseCase {
  ItemPedido addItemPedido(String numeroPedido, Item item, Integer quantidade);
}

