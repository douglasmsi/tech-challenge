package br.com.fiap.postech.fastfood.mock.item;

import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public final class ItemEntityMock {

    public ItemEntity criaItemEntity() {
        return ItemEntity.builder()
                .nome("X-Burguer")
                .descricao("Muito bom")
                .valor(BigDecimal.TEN)
                .categoriaItem(CategoriaItem.LANCHE)
                .build();
    }

}
