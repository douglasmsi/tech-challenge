package br.com.fiap.postech.fastfood.usecases.itempedido.impl;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.itempedido.DeletarItemPedidoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletarItemPedidoUseCaseImpl implements DeletarItemPedidoUseCase {
  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public ItemPedido deleteItemPedido(ItemPedido itemPedido) {
    return itemPedidoPersistencePort.deleteItemPedido(itemPedido);
  }
}
