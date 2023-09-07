package br.com.fiap.postech.fastfood.repository.item;

import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findByCategoriaItem(CategoriaItem categoriaItem);
}
