package br.com.fiap.postech.fastfood.adapters.persistence.itempedido;

import br.com.fiap.postech.fastfood.mock.item.ItemEntityMock;
import br.com.fiap.postech.fastfood.mock.item_pedido.ItemPedidoEntityMock;
import br.com.fiap.postech.fastfood.mock.pedido.PedidoEntityMock;
import br.com.fiap.postech.fastfood.repository.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.repository.itempedido.ItemPedidoJpaRepository;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
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
class ItemPedidoJpaRepositoryTest {

    @Autowired
    private ItemPedidoJpaRepository itemPedidoJpaRepository;

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    @Autowired
    private ItemJpaRepository itemJpaRepository;

    @BeforeEach
    void setUp() {
        salvaItemPedidoEntity();
    }

    @DisplayName("Quando executar a busca findByPedidoAndItem com pedido e item deve retornar ItemPedidoEntity")
    @Test
    void whenCallFindByPedidoAndItem_shouldReturnItemPedidoEntity() {
        // Arrange
        final var expectedPedido = this.pedidoJpaRepository.findByNumeroPedido("123456");
        final var expectedItem = this.itemJpaRepository.findById(1L).get();

        // Act
        final var itemPedidoEntity = this.itemPedidoJpaRepository.findByPedidoAndItem(expectedPedido, expectedItem);

        // Assert
        assertNotNull(itemPedidoEntity);
        assertEquals(expectedPedido, itemPedidoEntity.getPedido());
        assertEquals(expectedItem, itemPedidoEntity.getItem());
    }

    void salvaItemPedidoEntity() {
        final var pedidoEntity = PedidoEntityMock.criaPedidoEntity();
        this.pedidoJpaRepository.save(pedidoEntity);
        final var itemEntity = ItemEntityMock.criaItemEntity();
        this.itemJpaRepository.save(itemEntity);
        this.itemPedidoJpaRepository.save(ItemPedidoEntityMock.criaItemPedidoEntity(pedidoEntity, itemEntity));
    }

}
