package br.com.fiap.postech.fastfood.mock.cliente;

import br.com.fiap.postech.fastfood.repository.entities.ClienteEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ClienteEntityMock {

    public ClienteEntity criaClienteEntity() {
        return ClienteEntity.builder().cpf("12345678901").nome("João").build();
    }

}
