package br.com.fiap.postech.fastfood.usecases.item;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
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
