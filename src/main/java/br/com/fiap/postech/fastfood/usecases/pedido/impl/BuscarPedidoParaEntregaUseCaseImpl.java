package br.com.fiap.postech.fastfood.usecases.pedido.impl;

import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pedido.BuscarPedidoParaEntregaUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BuscarPedidoParaEntregaUseCaseImpl implements BuscarPedidoParaEntregaUseCase {

  private final PedidoPersistencePort pedidoPersistencePort;
  @Override
  public List<Pedido> findAllPedidosParaEntrega() {

    return pedidoPersistencePort.findAll().stream()
        .filter(pedido -> pedido.getStatusPedido() == PedidoStatus.ENTREGA || pedido.getStatusPedido() == PedidoStatus.ANDAMENTO || pedido.getStatusPedido() == PedidoStatus.CRIADO)
        .sorted(Comparator.comparing(Pedido::getDataPedido)
            .thenComparing(pedido -> {
              if (pedido.getStatusPedido() == PedidoStatus.ENTREGA) {
                return 0;
              } else if (pedido.getStatusPedido() == PedidoStatus.ANDAMENTO) {
                return 1;
              } else if (pedido.getStatusPedido() == PedidoStatus.CRIADO) {
                return 2;
              } else {
                return 3;
              }
            }))
        .collect(Collectors.toList());
  }
}
