package br.com.fiap.postech.fastfood.usecases.itempedido;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;

public interface DeletarItemPedidoUseCase {
  ItemPedido deleteItemPedido(ItemPedido itemPedido);
}
