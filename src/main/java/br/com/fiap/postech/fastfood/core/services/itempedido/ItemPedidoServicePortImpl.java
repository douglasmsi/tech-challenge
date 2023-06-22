package br.com.fiap.postech.fastfood.core.services.itempedido;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemPedidoServicePortImpl implements ItemPedidoServicePort {

  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public ItemPedido addItemPedido(String numeroPedido, Item item, Integer quantidade) {
    return itemPedidoPersistencePort.addItemPedido(numeroPedido, item, quantidade);
  }

  @Override
  public ItemPedido updateItemPedido(ItemPedido itemPedido) {
    return itemPedidoPersistencePort.updateItemPedido(itemPedido);
  }

  @Override
  public ItemPedido deleteItemPedido(ItemPedido itemPedido) {
    return itemPedidoPersistencePort.deleteItemPedido(itemPedido);
  }



  @Override
  public List<ItemPedido> findByID(Long id) {
    return itemPedidoPersistencePort.findByID(id);
  }

  @Override
  public List<ItemPedido> findAll() {
    return itemPedidoPersistencePort.findAll();
  }
}
