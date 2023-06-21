package br.com.fiap.postech.fastfood.core.ports.pedido;

import br.com.fiap.postech.fastfood.core.domain.Pedido;

import java.util.List;

public interface PedidoPersistencePort {

    Pedido createPedido(Pedido pedido);
    List<Pedido> findAll();
    Pedido findByNumeroPedido(String numeroPedido);

}