package br.com.fiap.postech.fastfood.usecases.pedido.impl;

import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pedido.BuscarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoPersistencePort pedidoPersistencePort;

  @Override
  public List<Pedido> findAll() {
    return pedidoPersistencePort.findAll();
  }

  @Override
  public Pedido findByNumeroPedido(final String numeroPedido) {
    return pedidoPersistencePort.findByNumeroPedido(numeroPedido);
  }
}
