package br.com.fiap.postech.fastfood.adapters.persistence.itempedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemPedidoJpaRepository extends JpaRepository<ItemPedidoEntity, Long> {
  ItemPedidoEntity findByPedidoAndItem(PedidoEntity pedido, ItemEntity item);



}