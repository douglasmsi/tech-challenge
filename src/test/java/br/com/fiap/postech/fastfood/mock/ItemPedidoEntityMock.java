package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemPedidoEntityMock {

    public static ItemPedidoEntity criaItemPedidoEntity() {
        var pedido = new ItemPedidoEntity();
        pedido.setNumeroPedido("123456");
        pedido.setPedidoStatus(PedidoStatus.CRIADO);
        pedido.setValorTotal(BigDecimal.TEN);
        return pedido;
    }

}
