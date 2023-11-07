package br.com.fiap.postech.fastfood.core.services.item;

import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePortImpl;
import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import br.com.fiap.postech.fastfood.repository.item.ItemJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServicePortImplTest {

    @InjectMocks
    private ItemPersistencePortImpl itemPersistencePortImpl;

    @Mock
    private ItemJpaRepository itemJpaRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void whenCallSave_shouldReturnItemSaved() {
        final var expectedItemEntity = ItemEntity.builder()
                .nome("Coca Cola")
                .categoriaItem(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        final var expectedItem = Item.builder()
                .nome("Coca Cola")
                .categoria(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        when(itemJpaRepository.save(any())).thenReturn(expectedItemEntity);

        final var item = itemPersistencePortImpl.save(expectedItem);

        assertNotNull(item.getCategoria());
        assertNotNull(item.getValor());
        assertNotNull(item.getNome());
    }

    @Test
    void whenCallFindAll_shouldReturnItens() {
        final var expectedItem = ItemEntity.builder()
                .nome("Coca Cola")
                .categoriaItem(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        final var expectedItem2 = ItemEntity.builder()
                .nome("X-Burguer")
                .categoriaItem(CategoriaItem.LANCHE)
                .valor(BigDecimal.ONE)
                .build();

        when(itemJpaRepository.findAll()).thenReturn(List.of(expectedItem, expectedItem2));

        final var itens = itemPersistencePortImpl.findAll();

        assertFalse(itens.isEmpty());
        assertEquals(2, itens.size());
    }

    @Test
    void whenCallFindById_shouldReturnItem() {
        final var expectedItem = ItemEntity.builder()
                .nome("Coca Cola")
                .categoriaItem(CategoriaItem.BEBIDA)
                .valor(BigDecimal.TEN)
                .build();

        when(itemJpaRepository.findById(anyLong())).thenReturn(Optional.of(expectedItem));

        final var item = itemPersistencePortImpl.findById(1L);

        assertNotNull(item);
        assertEquals(expectedItem.getNome(), item.getNome());
        assertEquals(expectedItem.getCategoriaItem(), item.getCategoria());
        assertEquals(expectedItem.getValor(), item.getValor());
    }

    @Test
    void whenCallDeletarItem_shouldDeleteItem() {
        doNothing().when(itemJpaRepository).deleteById(anyLong());
        assertDoesNotThrow(() -> itemPersistencePortImpl.deletarItem(1L));
    }

}
