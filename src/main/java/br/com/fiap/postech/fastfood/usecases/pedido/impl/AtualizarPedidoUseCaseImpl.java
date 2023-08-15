package br.com.fiap.postech.fastfood.usecases.pedido.impl;

import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pedido.AtualizarPedidoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarPedidoUseCaseImpl implements AtualizarPedidoUseCase {

  private final PedidoPersistencePort pedidoPersistencePort;

  @Override
  public Pedido updateStatusPedido(UpdatePedidoRequest pedido) {
    // Retrieve the existing Pedido from the persistence layer
    Pedido existingPedido = pedidoPersistencePort.findByNumeroPedido(pedido.getNumeroPedido());

    // Check if the existing Pedido is in a status that allows updates
    PedidoStatus currentStatus = existingPedido.getStatusPedido();
    if (currentStatus == PedidoStatus.CANCELADO || currentStatus == PedidoStatus.FINALIZADO) {
      throw new IllegalStateException("Cannot update Pedido in status CANCELADO or FINALIZADO.");
    }

    // Perform status transition validation
    PedidoStatus newStatus = pedido.getStatusPedido();
    switch (currentStatus) {
      case CRIADO:
        if (newStatus != PedidoStatus.ANDAMENTO && newStatus != PedidoStatus.CANCELADO) {
          throw new IllegalStateException("Invalid status transition from CRIADO.");
        }
        break;
      case ANDAMENTO:
        if (newStatus != PedidoStatus.CANCELADO && newStatus != PedidoStatus.ENTREGA && newStatus != PedidoStatus.FINALIZADO) {
          throw new IllegalStateException("Invalid status transition from EM_ANDAMENTO.");
        }
        break;
      case ENTREGA:
        if (newStatus != PedidoStatus.CANCELADO && newStatus != PedidoStatus.FINALIZADO) {
          throw new IllegalStateException("Invalid status transition from ENTREGA.");
        }
        break;
      default:
        throw new IllegalStateException("Invalid current status.");
    }

    // Perform additional validation based on the new status
    if (newStatus == PedidoStatus.ANDAMENTO) {
      // Check if the Pagamento status is APROVADO
      if (existingPedido.getStatusPagamento() != PagamentoStatus.APROVADO) {
        throw new IllegalStateException("Cannot update Pedido to EM_ANDAMENTO unless Pagamento status is APROVADO.");
      }
    }

    // Update the Pedido
    return pedidoPersistencePort.updateStatusPedido(pedido);
  }
}
