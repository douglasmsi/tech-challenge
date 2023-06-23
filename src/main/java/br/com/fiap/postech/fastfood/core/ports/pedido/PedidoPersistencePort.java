package br.com.fiap.postech.fastfood.core.ports.pedido;

import br.com.fiap.postech.fastfood.core.domain.Pedido;

import java.util.List;

public interface PedidoPersistencePort {

    Pedido createPedido(final Pedido pedido);

    Pedido updateStatusPedido(final Pedido pedido);

    List<Pedido> findAll();

    Pedido findByNumeroPedido(final String numeroPedido);

}