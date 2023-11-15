package br.com.fiap.postech.fastfood.mock.item_pedido;

import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import br.com.fiap.postech.fastfood.repository.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ItemPedidoEntityMock {

    public ItemPedidoEntity criaItemPedidoEntity(PedidoEntity pedidoEntity, ItemEntity itemEntity) {
        return ItemPedidoEntity.builder().pedido(pedidoEntity).item(itemEntity).quantidade(1).build();
    }

}
