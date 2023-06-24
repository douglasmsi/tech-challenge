package br.com.fiap.postech.fastfood.adapters.persistence.itempedido;

import br.com.fiap.postech.fastfood.adapters.persistence.pedido.PedidoJpaRepository;
import br.com.fiap.postech.fastfood.mock.PedidoEntityMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus.CRIADO;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class ItemPedidoJpaRepositoryTest {

        @Autowired
        private ItemPedidoJpaRepository itemPedidoJpaRepository;

        @BeforeEach
        void setUp() {
            salvaItemPedidoEntity();
        }

        @DisplayName("Quando executar a busca findByNumeroPedido com numero de pedido deve retornar PedidoEntity")
        @Test
        void when_callFindByNumeroPedido_shouldReturnPedidoEntity() {
            // Arrange
            final var expectedNumeroPedido = "123456";
            final var expectedPedidoStatus = CRIADO;
            final var expectedValorTotal = BigDecimal.TEN;

            // Act
            var pedidoEntity = this.pedidoJpaRepository.findByNumeroPedido(expectedNumeroPedido);

            // Assert
            assertNotNull(pedidoEntity);
            assertEquals(expectedNumeroPedido, pedidoEntity.getNumeroPedido());
            assertEquals(expectedPedidoStatus, pedidoEntity.getPedidoStatus());
            assertEquals(expectedValorTotal, pedidoEntity.getValorTotal());
        }

        void salvaItemPedidoEntity() {
            var pedidoEntity = PedidoEntityMock.criaPedidoEntity();
            this.pedidoJpaRepository.save(pedidoEntity);
        }
