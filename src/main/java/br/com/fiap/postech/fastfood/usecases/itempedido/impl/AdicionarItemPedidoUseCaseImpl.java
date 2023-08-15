package br.com.fiap.postech.fastfood.usecases.itempedido.impl;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.itempedido.AdicionarItemPedidoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdicionarItemPedidoUseCaseImpl implements AdicionarItemPedidoUseCase {
  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public ItemPedido addItemPedido(String numeroPedido, Item item, Integer quantidade) {
    return itemPedidoPersistencePort.addItemPedido(numeroPedido, item, quantidade);
  }
}

