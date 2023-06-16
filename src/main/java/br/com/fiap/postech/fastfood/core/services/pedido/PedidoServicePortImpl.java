package br.com.fiap.postech.fastfood.core.services.pedido;

import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PedidoServicePortImpl implements PedidoServicePort {

    private final PedidoPersistencePort pedidoPersistencePort;

    @Override
    public Pedido save(final Pedido pedido) {
        return pedidoPersistencePort.save(pedido);
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