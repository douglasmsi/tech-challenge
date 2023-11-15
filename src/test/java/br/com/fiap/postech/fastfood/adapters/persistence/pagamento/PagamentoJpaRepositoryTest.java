package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.mock.pagamento.PagamentoEntityMock;
import br.com.fiap.postech.fastfood.mock.pedido.PedidoEntityMock;
import br.com.fiap.postech.fastfood.repository.pagamento.PagamentoJpaRepository;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus.PENDENTE;
import static br.com.fiap.postech.fastfood.domain.enums.PedidoStatus.CRIADO;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class PagamentoJpaRepositoryTest {

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    @BeforeEach
    void setUp() {
        salvaPagamentoEntity();
    }

    @DisplayName("Quando executar a busca findAllByStatus com status deve retornar lista de PagamentoEntity")
    @Test
    void whenCallfindAllByStatus_shouldReturnListOfPagamentoEntity() {
        // Arrange
        final var expectedPedidoStatus = CRIADO;
        final var expectedPagamentoStatus = PENDENTE;

        // Act
        final var pagamentoEntity = this.pagamentoJpaRepository.findAllByStatus(PENDENTE);

        // Assert
        assertNotNull(pagamentoEntity);
        assertFalse(pagamentoEntity.isEmpty());
        assertEquals(expectedPagamentoStatus, pagamentoEntity.get(0).getStatus());
        assertEquals(expectedPedidoStatus, pagamentoEntity.get(0).getPedido().getPedidoStatus());
    }

    void salvaPagamentoEntity() {
        final var pedidoEntity = PedidoEntityMock.criaPedidoEntity();
        this.pedidoJpaRepository.save(pedidoEntity);
        final var pagamentoEntity = PagamentoEntityMock.criaPagamentoEntity();
        pagamentoEntity.setPedido(pedidoEntity);
        this.pagamentoJpaRepository.save(pagamentoEntity);
    }

}
