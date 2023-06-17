package br.com.fiap.postech.fastfood.core.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Builder
public record Pedido(
        String numeroPedido,
        PedidoStatus status,
        BigDecimal valorTotal,
        List<ItemPedido> items
) {}
