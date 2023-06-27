package br.com.fiap.postech.fastfood.adapters.persistence.item;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.ports.item.ItemPersistencePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ItemPersistencePortImpl implements ItemPersistencePort {

    private final ItemJpaRepository itemJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Item save(final Item item) {
        var itemEntityEntity = itemJpaRepository.save(modelMapper.map(item, ItemEntity.class));
        return modelMapper.map(itemEntityEntity, Item.class);
    }

    @Override
    public List<Item> findAll() {
        return itemJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Item.class)).toList();
    }

    @Override
    public Item findById(final Long id) {
        Optional<ItemEntity> itemEntityEntity = itemJpaRepository.findById(id);
        return itemEntityEntity.isPresent() ? modelMapper.map(itemEntityEntity.get(), Item.class) : null;
    }

    @Override
    public List<Item> findAllByCategoria(final CategoriaItem categoriaItem) {
        return itemJpaRepository.findByCategoriaItem(categoriaItem).stream().map(entity -> modelMapper.map(entity, Item.class)).toList();
    }

    @Override
    public void deletarItem(final Long id) {
        itemJpaRepository.deleteById(id);
    }

}
