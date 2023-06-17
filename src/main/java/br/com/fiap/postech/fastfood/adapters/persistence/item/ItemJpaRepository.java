package br.com.fiap.postech.fastfood.adapters.persistence.item;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
}
