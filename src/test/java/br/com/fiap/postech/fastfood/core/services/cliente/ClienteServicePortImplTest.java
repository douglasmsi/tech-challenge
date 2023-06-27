package br.com.fiap.postech.fastfood.core.services.cliente;

import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServicePortImplTest {

    @InjectMocks
    private ClienteServicePortImpl clienteServicePortImpl;

    @Mock
    private ClientePersistencePort clientePersistencePort;

    @Test
    void whenCallSave_shouldReturnClienteSaved() {
        final var expectedCliente = Cliente.builder().cpf("Cpf").telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();

        when(clientePersistencePort.save(any())).thenReturn(expectedCliente);

        final var cliente = clienteServicePortImpl.save(expectedCliente);

        assertNotNull(cliente);
        assertNotNull(cliente.getCpf());
        assertNotNull(cliente.getTelefone());
        assertNotNull(cliente.getNome());
        assertNotNull(cliente.getEndereco());
        assertNotNull(cliente.getEmail());
    }

    @Test
    void whenCallFindAll_shouldReturnClientes() {
        final var cliente = Cliente.builder().cpf("Cpf").telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();
        final var cliente2 = Cliente.builder().cpf("Cpf2").telefone("Telefone2").nome(
                "Nome2").endereco("Endereco2").email("Email2").build();

        when(clientePersistencePort.findAll()).thenReturn(List.of(cliente, cliente2));

        final var clientes = clienteServicePortImpl.findAll();

        assertFalse(clientes.isEmpty());
        assertEquals(2, clientes.size());
    }

    @Test
    void whenCallFindAll_shouldReturnEmpty() {
        when(clientePersistencePort.findAll()).thenReturn(List.of());

        final var clientes = clienteServicePortImpl.findAll();

        assertTrue(clientes.isEmpty());
    }

    @Test
    void whenCallFindByCpf_shouldReturnCliente() {
        final var expectedCPF = "12345678901";
        final var expectedCliente = Cliente.builder().cpf(expectedCPF).telefone("Telefone").nome(
                "Nome").endereco("Endereco").email("Email").build();

        when(clientePersistencePort.findByCpf(anyString())).thenReturn(expectedCliente);

        final var cliente = clienteServicePortImpl.findByCpf("12345678901");

        assertNotNull(cliente);
        assertEquals(expectedCPF, cliente.getCpf());
    }

    @Test
    void whenCallFindByNome_shouldReturnCliente() {
        final var expectedNome = "Jose";
        final var expectedCliente = Cliente.builder().cpf("12345678901").telefone("Telefone").nome(
                expectedNome).endereco("Endereco").email("Email").build();

        when(clientePersistencePort.findByNome(anyString())).thenReturn(expectedCliente);

        final var cliente = clienteServicePortImpl.findByNome(expectedNome);

        assertNotNull(cliente);
        assertEquals(expectedNome, cliente.getNome());
    }

}
