package br.com.fiap.postech.fastfood.core.services.itempedido;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ItemPedidoServicePortImpl implements ItemPedidoServicePort {

  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public ItemPedido addItemPedido(final String numeroPedido, final Item item, final Integer quantidade) {
    return itemPedidoPersistencePort.addItemPedido(numeroPedido, item, quantidade);
  }

  @Override
  public ItemPedido updateItemPedido(final ItemPedido itemPedido) {
    return itemPedidoPersistencePort.updateItemPedido(itemPedido);
  }

  @Override
  public ItemPedido deleteItemPedido(final ItemPedido itemPedido) {
    return itemPedidoPersistencePort.deleteItemPedido(itemPedido);
  }

  @Override
  public List<ItemPedido> findByID(final Long id) {
    return itemPedidoPersistencePort.findByID(id);
  }

  @Override
  public List<ItemPedido> findAll() {
    return itemPedidoPersistencePort.findAll();
  }

  @Override
  public List<ItemPedido> findByNumeroPedido(final String numeroPedido) {
    return itemPedidoPersistencePort.findByNumeroPedido(numeroPedido);
  }

}
