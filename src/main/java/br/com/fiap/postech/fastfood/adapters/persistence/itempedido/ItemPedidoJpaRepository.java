package br.com.fiap.postech.fastfood.adapters.persistence.itempedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface ItemPedidoJpaRepository extends JpaRepository<ItemPedidoEntity, Long> {
  ItemPedidoEntity findByPedidoAndItem(final PedidoEntity pedido, final ItemEntity item);
  List<ItemPedidoEntity> findByPedido(final PedidoEntity pedido);

}
