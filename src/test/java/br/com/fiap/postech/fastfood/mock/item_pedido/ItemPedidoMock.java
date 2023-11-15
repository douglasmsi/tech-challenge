package br.com.fiap.postech.fastfood.mock.item_pedido;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.mock.item.ItemMock;
import br.com.fiap.postech.fastfood.mock.pedido.PedidoMock;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public final class ItemPedidoMock {

    public ItemPedido create() {
        return ItemPedido.builder()
                .item(ItemMock.create())
                .quantidade(1)
                .valor(BigDecimal.TEN)
                .observacao("Observacao")
                .pedido(PedidoMock.create()).build();
    }

}
