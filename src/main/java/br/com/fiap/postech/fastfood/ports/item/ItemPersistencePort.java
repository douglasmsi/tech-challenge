package br.com.fiap.postech.fastfood.ports.item;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;

import java.util.List;

public interface ItemPersistencePort {

    Item save(Item item);
    List<Item> findAll();
    Item findById(Long id);
    List<Item> findAllByCategoria(CategoriaItem categoriaItem);

    void deletarItem(Long id);
}
