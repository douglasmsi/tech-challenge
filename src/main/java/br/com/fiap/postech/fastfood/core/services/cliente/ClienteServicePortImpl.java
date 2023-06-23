package br.com.fiap.postech.fastfood.core.services.cliente;

import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClienteServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClienteServicePortImpl implements ClienteServicePort {

    private final ClientePersistencePort clientePersistencePort;

    @Override
    public Cliente save(final Cliente cliente) {
        return clientePersistencePort.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clientePersistencePort.findAll();
    }

    @Override
    public Cliente findByCpf(final String cpf) {
        return clientePersistencePort.findByCpf(cpf);
    }

    @Override
    public Cliente findByNome(final String nome) {
        return clientePersistencePort.findByNome(nome);
    }

}
