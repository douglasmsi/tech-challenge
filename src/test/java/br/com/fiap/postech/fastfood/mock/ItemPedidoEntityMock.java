package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemPedidoEntityMock {

    public static ItemPedidoEntity criaItemPedidoEntity(PedidoEntity pedidoEntity, ItemEntity itemEntity) {
        return ItemPedidoEntity.builder().pedido(pedidoEntity).item(itemEntity).quantidade(1).build();
    }

}
