package br.com.fiap.postech.fastfood.core.services.item;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.item.ItemServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class ItemServicePortImpl implements ItemServicePort {

      private final ItemPersistencePort itemPersistencePort;

      @Override
      public Item save(Item item) {
        return itemPersistencePort.save(item);
      }

      @Override
      public List<Item> findAll() {
        return itemPersistencePort.findAll();
      }

      @Override
      public Item findById(Long id) {
        return itemPersistencePort.findById(id);
      }

    @Override
    public List<Item> findAllByCategoria(CategoriaItem categoriaItem) {
        return itemPersistencePort.findAllByCategoria(categoriaItem);
    }

    @Override
    public void deletarItem(Long id) {
        itemPersistencePort.deletarItem(id);
    }
}
