package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Component
public class ClientePersistencePortImpl implements ClientePersistencePort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity = clienteJpaRepository.save(modelMapper.map(cliente, ClienteEntity.class));
        return modelMapper.map(clienteEntity, Cliente.class);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Cliente.class)).collect(Collectors.toList());
    }

    @Override
    public Cliente findByNome(String nome) {
        //TODO: Implementar
        return null;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteJpaRepository.findByCpf(cpf);
    }
}
