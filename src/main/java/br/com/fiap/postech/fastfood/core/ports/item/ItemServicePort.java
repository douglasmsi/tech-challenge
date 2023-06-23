package br.com.fiap.postech.fastfood.core.ports.item;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;

import java.util.List;

public interface ItemServicePort {

    Item save(final Item item);

    List<Item> findAll();

    Item findById(final Long id);

    List<Item> findAllByCategoria(final CategoriaItem categoriaItem);

    void deletarItem(final Long id);

}
