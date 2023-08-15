package br.com.fiap.postech.fastfood.usecases.itempedido.impl;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.itempedido.BuscarItemPedidoUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarItemPedidoUseCaseImpl implements BuscarItemPedidoUseCase {
  private final ItemPedidoPersistencePort itemPedidoPersistencePort;

  @Override
  public List<ItemPedido> findByNumeroPedido(String numeroPedido) {
    return itemPedidoPersistencePort.findByNumeroPedido(numeroPedido);
  }

  @Override
  public List<ItemPedido> findAll() {
    return itemPedidoPersistencePort.findAll();
  }
}

