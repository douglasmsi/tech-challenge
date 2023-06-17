package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.core.services.exception.ClienteNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
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
        Optional<ClienteEntity> cliente = clienteJpaRepository.findByCpf(nome);
        if(cliente.isPresent()){
            return modelMapper.map(cliente.get(), Cliente.class);
        }
        return null;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        Optional<ClienteEntity> cliente = clienteJpaRepository.findByCpf(cpf);
        if(cliente.isPresent()){
            return modelMapper.map(cliente.get(), Cliente.class);
        }
        return null;
    }
}
