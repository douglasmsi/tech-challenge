package br.com.fiap.postech.fastfood.core.services.pedido;

import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PedidoServicePortImpl implements PedidoServicePort {

    private final PedidoPersistencePort pedidoPersistencePort;

    @Override
    public Pedido createPedido(final Pedido pedido) {
        return pedidoPersistencePort.createPedido(pedido);
    }

    @Override
    public Pedido updateStatusPedido(final Pedido pedido) {
        // Retrieve the existing Pedido from the persistence layer
        var existingPedido = pedidoPersistencePort.findByNumeroPedido(pedido.getNumeroPedido());

        // Check if the existing Pedido is in a status that allows updates
        var currentStatus = existingPedido.getStatusPedido();
        if (PedidoStatus.CANCELADO.equals(currentStatus) || PedidoStatus.FINALIZADO.equals(currentStatus)) {
            throw new IllegalStateException("Cannot update Pedido in status CANCELADO or FINALIZADO.");
        }

        // Perform status transition validation
        var newStatus = pedido.getStatusPedido();
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
        if (PedidoStatus.ANDAMENTO.equals(newStatus)) {
            // Check if the Pagamento status is APROVADO
            if (existingPedido.getStatusPagamento() != PagamentoStatus.APROVADO) {
                throw new IllegalStateException("Cannot update Pedido to EM_ANDAMENTO unless Pagamento status is APROVADO.");
            }
        }

        // Update the Pedido
        return pedidoPersistencePort.updateStatusPedido(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoPersistencePort.findAll();
    }

    @Override
    public Pedido findByNumeroPedido(final String numeroPedido) {
        return pedidoPersistencePort.findByNumeroPedido(numeroPedido);
    }

}
