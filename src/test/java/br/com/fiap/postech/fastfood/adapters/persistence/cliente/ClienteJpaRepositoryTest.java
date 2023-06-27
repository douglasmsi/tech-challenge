package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.mock.ClienteEntityMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DataJpaTest
class ClienteJpaRepositoryTest {

    @Autowired
    private ClienteJpaRepository clienteJpaRepository;

    @BeforeEach
    void setUp() {
        salvaClienteEntity();
    }

    @DisplayName("Quando executar a busca findByCpf com CPF deve retornar ClienteEntity")
    @Test
    void whenCallFindByCpf_shouldReturnClienteEntity() {
        // Arrange
        final var expectedCPF = "12345678901";

        // Act
        final var clienteEntity = this.clienteJpaRepository.findByCpf(expectedCPF);

        // Assert
        assertNotNull(clienteEntity);
        assertEquals(expectedCPF, clienteEntity.get().getCpf());
    }

    private void salvaClienteEntity() {
        clienteJpaRepository.save(ClienteEntityMock.criaClienteEntity());
    }

}
