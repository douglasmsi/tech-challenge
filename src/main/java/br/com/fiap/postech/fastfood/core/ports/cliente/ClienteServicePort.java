package br.com.fiap.postech.fastfood.core.ports.cliente;

import br.com.fiap.postech.fastfood.core.domain.Cliente;

import java.util.List;

public interface ClienteServicePort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByCpf(String cpf);
    Cliente findByNome(String nome);

}
