package br.com.fiap.postech.fastfood.core.ports.item;

import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;

import java.util.List;

public interface ItemPersistencePort {

    Item save(Item item);
    List<Item> findAll();
    Item findById(Long id);
    List<Item> findAllByCategoria(CategoriaItem categoriaItem);

    void deletarItem(Long id);
}
