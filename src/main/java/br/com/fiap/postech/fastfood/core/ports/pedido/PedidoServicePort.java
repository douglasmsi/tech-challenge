package br.com.fiap.postech.fastfood.core.ports.pedido;

import br.com.fiap.postech.fastfood.core.domain.Pedido;

import java.util.List;

public interface PedidoServicePort {

    Pedido createPedido(Pedido pedido);
    Pedido updatePedido(Pedido pedido);
    List<Pedido> findAll();
    Pedido findByNumeroPedido(String numeroPedido);

}