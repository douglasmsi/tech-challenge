package br.com.fiap.postech.fastfood.usecases.itempedido.impl;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.itempedido.AtualizarItemPedidoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarItemPedidoUseCaseImpl implements AtualizarItemPedidoUseCase {
  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public ItemPedido updateItemPedido(ItemPedido itemPedido) {
    return itemPedidoPersistencePort.updateItemPedido(itemPedido);
  }
}

