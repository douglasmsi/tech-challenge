package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ItemEntityMock {

    public static ItemEntity criaItemEntity() {
        return ItemEntity.builder()
                .nome("X-Burguer")
                .descricao("Lanche")
                .categoriaItem(CategoriaItem.LANCHE)
                .valor(BigDecimal.TEN).build();
    }

}
