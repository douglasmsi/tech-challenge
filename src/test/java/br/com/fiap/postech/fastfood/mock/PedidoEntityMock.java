package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PedidoEntityMock {

    public static PedidoEntity criaPedidoEntity() {
        var pedido = new PedidoEntity();
        pedido.setNumeroPedido("123456");
        pedido.setPedidoStatus(PedidoStatus.CRIADO);
        pedido.setValorTotal(BigDecimal.TEN);
        return pedido;
    }

}
