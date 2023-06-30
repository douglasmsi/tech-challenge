package br.com.fiap.postech.fastfood.core.ports.pedido;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.CriarPedidoRequest;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.domain.Pedido;

import java.util.List;

public interface PedidoServicePort {

    Pedido createPedido(final Cliente request);
    Pedido updateStatusPedido(final UpdatePedidoRequest request);
    List<Pedido> findAll();
    Pedido findByNumeroPedido(final String numeroPedido);

}