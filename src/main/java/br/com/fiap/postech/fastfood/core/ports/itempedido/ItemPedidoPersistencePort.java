package br.com.fiap.postech.fastfood.core.ports.itempedido;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;

import java.util.List;

public interface ItemPedidoPersistencePort {

  ItemPedido addItemPedido(final String numeroPedido, final Item item, final Integer quantidade);
  ItemPedido updateItemPedido(final ItemPedido itemPedido);
  ItemPedido deleteItemPedido(final ItemPedido itemPedido);
  List<ItemPedido> findAll();
  List<ItemPedido> findByID(final Long id);
  List<ItemPedido> findByNumeroPedido(final String numeroPedido);

}
