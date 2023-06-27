package br.com.fiap.postech.fastfood.core.ports.cliente;

import br.com.fiap.postech.fastfood.core.domain.Cliente;

import java.util.List;

public interface ClientePersistencePort {

    Cliente save(final Cliente cliente);
    List<Cliente> findAll();
    Cliente findByNome(final String nome);
    Cliente findByCpf(final String cpf);

}
