package br.com.fiap.postech.fastfood.adapters.persistence.pedido;

import br.com.fiap.postech.fastfood.mock.pedido.PedidoEntityMock;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static br.com.fiap.postech.fastfood.domain.enums.PedidoStatus.CRIADO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DataJpaTest
class PedidoJpaRepositoryTest {

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    @BeforeEach
    void setUp() {
        salvaPedidoEntity();
    }

    @Test
    void whenCallFindByNumeroPedido_shouldReturnPedidoEntity() {
        // Arrange
        final var expectedNumeroPedido = "123456";
        final var expectedPedidoStatus = CRIADO;
        final var expectedValorTotal = BigDecimal.TEN;

        // Act
        final var pedidoEntity = this.pedidoJpaRepository.findByNumeroPedido(expectedNumeroPedido);

        // Assert
        assertNotNull(pedidoEntity);
        assertEquals(expectedNumeroPedido, pedidoEntity.getNumeroPedido());
        assertEquals(expectedPedidoStatus, pedidoEntity.getPedidoStatus());
        assertEquals(expectedValorTotal, pedidoEntity.getValorTotal());
    }

    void salvaPedidoEntity() {
        final var pedidoEntity = PedidoEntityMock.criaPedidoEntity();
        this.pedidoJpaRepository.save(pedidoEntity);
    }

}
