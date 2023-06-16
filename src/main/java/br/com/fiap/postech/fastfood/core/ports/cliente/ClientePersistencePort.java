package br.com.fiap.postech.fastfood.core.ports.cliente;

import br.com.fiap.postech.fastfood.core.domain.Cliente;

import java.util.List;

public interface ClientePersistencePort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByNome(String nome);
    Cliente findByCpf(String cpf);

}
