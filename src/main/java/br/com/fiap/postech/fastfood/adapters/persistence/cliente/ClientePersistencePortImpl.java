package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClientePersistencePortImpl implements ClientePersistencePort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cliente save(final Cliente cliente) {
        var clienteEntity = clienteJpaRepository.save(modelMapper.map(cliente, ClienteEntity.class));
        return modelMapper.map(clienteEntity, Cliente.class);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Cliente.class)).toList();
    }

    @Override
    public Cliente findByNome(String nome) {
        Optional<ClienteEntity> cliente = clienteJpaRepository.findByCpf(nome);
        return cliente.isPresent() ? modelMapper.map(cliente.get(), Cliente.class) : null;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        Optional<ClienteEntity> cliente = clienteJpaRepository.findByCpf(cpf);
        return cliente.isPresent() ? modelMapper.map(cliente.get(), Cliente.class) : null;
    }

}
