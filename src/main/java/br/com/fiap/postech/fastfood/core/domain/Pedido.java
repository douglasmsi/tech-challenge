package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    String numeroPedido;
    PedidoStatus status;
    BigDecimal valorTotal;
    List<ItemPedido> items;
}
