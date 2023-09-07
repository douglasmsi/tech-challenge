package br.com.fiap.postech.fastfood.ports.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;

import java.util.List;

public interface ClientePersistencePort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByNome(String nome);
    Cliente findByCpf(String cpf);

}
