package br.com.fiap.postech.fastfood.core.services.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.ports.cliente.ClientePersistencePortImpl;
import br.com.fiap.postech.fastfood.repository.cliente.ClienteJpaRepository;
import br.com.fiap.postech.fastfood.repository.entities.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServicePortImplTest {

    @InjectMocks
    private ClientePersistencePortImpl clientePersistencePortImpl;

    @Mock
    private ClienteJpaRepository clienteJpaRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void whenCallSave_shouldReturnClienteSaved() {
        final var expectedCliente = Cliente.builder().cpf("Cpf").telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();
        final var expectedClienteEntity = ClienteEntity.builder().cpf("Cpf").telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();

        when(clienteJpaRepository.save(any())).thenReturn(expectedClienteEntity);

        final var cliente = clientePersistencePortImpl.save(expectedCliente);

        assertNotNull(cliente);
        assertNotNull(cliente.getCpf());
        assertNotNull(cliente.getTelefone());
        assertNotNull(cliente.getNome());
        assertNotNull(cliente.getEndereco());
        assertNotNull(cliente.getEmail());
    }

    @Test
    void whenCallFindAll_shouldReturnClientes() {
        final var cliente = ClienteEntity.builder().cpf("Cpf").telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();
        final var cliente2 = ClienteEntity.builder().cpf("Cpf2").telefone("Telefone2").nome(
                "Nome2").endereco("Endereco2").email("Email2").build();

        when(clienteJpaRepository.findAll()).thenReturn(List.of(cliente, cliente2));

        final var clientes = clientePersistencePortImpl.findAll();

        assertFalse(clientes.isEmpty());
        assertEquals(2, clientes.size());
    }

    @Test
    void whenCallFindAll_shouldReturnEmpty() {
        when(clienteJpaRepository.findAll()).thenReturn(List.of());

        final var clientes = clientePersistencePortImpl.findAll();

        assertTrue(clientes.isEmpty());
    }

    @Test
    void whenCallFindByCpf_shouldReturnCliente() {
        final var expectedCPF = "12345678901";
        final var expectedCliente = ClienteEntity.builder().cpf(expectedCPF).telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();

        when(clienteJpaRepository.findByCpf(anyString())).thenReturn(expectedCliente);

        final var cliente = clientePersistencePortImpl.findByCpf("12345678901");

        assertNotNull(cliente);
        assertEquals(expectedCPF, cliente.getCpf());
    }

    @Test
    void whenCallFindByNome_shouldReturnCliente() {
        final var expectedNome = "Jose";
        final var expectedCliente = ClienteEntity.builder().cpf("12345678901").telefone("Telefone").nome(
                expectedNome).endereco("Endereco").email("Email").build();

        when(clienteJpaRepository.findByNome(anyString())).thenReturn(expectedCliente);

        final var cliente = clientePersistencePortImpl.findByNome(expectedNome);

        assertNotNull(cliente);
        assertEquals(expectedNome, cliente.getNome());
    }

}
