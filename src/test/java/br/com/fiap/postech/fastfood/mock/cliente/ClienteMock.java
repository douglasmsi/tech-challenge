package br.com.fiap.postech.fastfood.mock.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@UtilityClass
public final class ClienteMock {

    public Cliente create() {
        return  Cliente.builder()
                .nome("Nome")
                .cpf("Cpf")
                .email("jane.doe@example.org")
                .endereco("Endereco")
                .telefone("Telefone")
                .pedidos(Collections.emptyList())
                .metodosPagamento(Collections.emptyList())
                .build();
    }
}
