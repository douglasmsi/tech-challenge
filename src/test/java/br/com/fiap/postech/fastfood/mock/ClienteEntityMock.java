package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteEntityMock {

    public static ClienteEntity criaClienteEntity() {
        return ClienteEntity.builder().cpf("12345678901").nome("João").build();
    }

}
