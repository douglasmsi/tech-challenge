package br.com.fiap.postech.fastfood.ports.itempedido;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;

import java.util.List;

public interface ItemPedidoPersistencePort {

  ItemPedido addItemPedido(final String numeroPedido, final Item item, final Integer quantidade);

  ItemPedido updateItemPedido(final ItemPedido itemPedido);

  ItemPedido deleteItemPedido(final ItemPedido itemPedido);

  List<ItemPedido> findAll();

  List<ItemPedido> findByNumeroPedido(final String numeroPedido);
}
