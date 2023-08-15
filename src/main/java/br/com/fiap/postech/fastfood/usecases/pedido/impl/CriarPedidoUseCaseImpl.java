package br.com.fiap.postech.fastfood.usecases.pedido.impl;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pedido.CriarPedidoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarPedidoUseCaseImpl implements CriarPedidoUseCase {

  private final PedidoPersistencePort pedidoPersistencePort;

  @Override
  public Pedido createPedido(final Cliente cliente) {
    return pedidoPersistencePort.createPedido(cliente);
  }
}
