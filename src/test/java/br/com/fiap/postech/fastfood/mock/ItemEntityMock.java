package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ItemEntityMock {

    public static ItemEntity criaItemEntity() {
        return ItemEntity.builder().nome("X-Burguer").valor(BigDecimal.TEN).build();
    }

}
