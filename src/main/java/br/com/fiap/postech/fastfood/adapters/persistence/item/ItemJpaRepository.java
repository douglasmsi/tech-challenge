package br.com.fiap.postech.fastfood.adapters.persistence.item;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findByCategoriaItem(final CategoriaItem categoriaItem);

}
