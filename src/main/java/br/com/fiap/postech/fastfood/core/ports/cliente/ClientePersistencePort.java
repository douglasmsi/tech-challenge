package br.com.fiap.postech.fastfood.core.ports.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;

import java.util.List;

public interface ClientePersistencePort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByNome(String nome);
    ClienteEntity findByCpf(String cpf);

}
