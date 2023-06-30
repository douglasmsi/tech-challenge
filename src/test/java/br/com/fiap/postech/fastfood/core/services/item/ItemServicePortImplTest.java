package br.com.fiap.postech.fastfood.core.services.item;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.ports.item.ItemPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServicePortImplTest {

    @InjectMocks
    private ItemServicePortImpl itemServicePortImpl;

    @Mock
    private ItemPersistencePort itemPersistencePort;

    @Test
    void whenCallSave_shouldReturnItemSaved() {
        final var expectedItem = Item.builder()
                .nome("Coca Cola")
                .categoria(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        when(itemPersistencePort.save(any())).thenReturn(expectedItem);

        final var item = itemServicePortImpl.save(expectedItem);

        assertNotNull(item.getCategoria());
        assertNotNull(item.getValor());
        assertNotNull(item.getNome());
    }

    @Test
    void whenCallFindAll_shouldReturnItens() {
        final var expectedItem = Item.builder()
                .nome("Coca Cola")
                .categoria(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        final var expectedItem2 = Item.builder()
                .nome("X-Burguer")
                .categoria(CategoriaItem.LANCHE)
                .valor(BigDecimal.ONE)
                .build();

        when(itemPersistencePort.findAll()).thenReturn(List.of(expectedItem, expectedItem2));

        final var itens = itemServicePortImpl.findAll();

        assertFalse(itens.isEmpty());
        assertEquals(2, itens.size());
    }

    @Test
    void whenCallFindById_shouldReturnItem() {
        final var expectedItem = Item.builder()
                .nome("Coca Cola")
                .categoria(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        when(itemPersistencePort.findById(anyLong())).thenReturn(expectedItem);

        final var item = itemServicePortImpl.findById(1L);

        assertNotNull(item);
        assertEquals(expectedItem.getNome(), item.getNome());
        assertEquals(expectedItem.getCategoria(), item.getCategoria());
        assertEquals(expectedItem.getValor(), item.getValor());
    }

    @Test
    void whenCallFindAllByCategoria_shouldReturnItens() {
        final var expectedItem = Item.builder()
                .nome("Coca Cola")
                .categoria(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        when(itemPersistencePort.findAllByCategoria(any())).thenReturn(List.of(expectedItem));

        final var itens = itemServicePortImpl.findAllByCategoria(CategoriaItem.BEBIDA);

        assertNotNull(itens);
        assertFalse(itens.isEmpty());
        assertEquals(1, itens.size());
    }

    @Test
    void whenCallDeletarItem_shouldDeleteItem() {
        doNothing().when(itemPersistencePort).deletarItem(anyLong());
        assertDoesNotThrow(() -> itemServicePortImpl.deletarItem(1L));
    }

}
