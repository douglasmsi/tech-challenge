package br.com.fiap.postech.fastfood.mock.item;

import br.com.fiap.postech.fastfood.controller.dto.ItemRequest;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.domain.item.Item;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public final class ItemMock {

    public Item create() {
        return Item.builder()
                .nome("X-Burguer")
                .descricao("Muito bom")
                .valor(BigDecimal.TEN)
                .categoria(CategoriaItem.LANCHE)
                .build();
    }

    public ItemRequest createItemRequest() {
        return ItemRequest.builder()
                .nome("X-Burguer")
                .descricao("Muito bom")
                .valor(BigDecimal.TEN)
                .categoria(CategoriaItem.LANCHE.getValue())
                .build();
    }

}
