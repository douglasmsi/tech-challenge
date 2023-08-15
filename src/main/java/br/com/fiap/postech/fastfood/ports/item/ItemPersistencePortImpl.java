package br.com.fiap.postech.fastfood.ports.item;


import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.repository.item.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ItemPersistencePortImpl implements ItemPersistencePort {

    private final ItemJpaRepository itemJpaRepository;

    private final ModelMapper modelMapper;
    @Override
    public Item save(Item item) {
        ItemEntity itemEntityEntity = itemJpaRepository.save(modelMapper.map(item, ItemEntity.class));
        return modelMapper.map(itemEntityEntity, Item.class);
    }

    @Override
    public List<Item> findAll() {
        return itemJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Item.class)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id) {
        Optional<ItemEntity> itemEntityEntity = itemJpaRepository.findById(id);
        if(itemEntityEntity.isPresent()){
            return modelMapper.map(itemEntityEntity.get(), Item.class);
        }
        return null;
    }

    @Override
    public List<Item> findAllByCategoria(CategoriaItem categoriaItem) {
        return itemJpaRepository.findByCategoriaItem(categoriaItem).stream().map(entity -> modelMapper.map(entity, Item.class)).collect(Collectors.toList());
    }

    @Override
    public void deletarItem(Long id) {
        itemJpaRepository.deleteById(id);
    }
}
