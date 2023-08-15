package br.com.fiap.postech.fastfood.ports.pedido;

import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;

import java.util.List;

public interface PedidoPersistencePort {

    Pedido createPedido(Cliente request);
    Pedido updateStatusPedido(UpdatePedidoRequest request);
    List<Pedido> findAll();
    Pedido findByNumeroPedido(String numeroPedido);


}