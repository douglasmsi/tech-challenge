package br.com.fiap.postech.fastfood.repository.itempedido;

import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import br.com.fiap.postech.fastfood.repository.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemPedidoJpaRepository extends JpaRepository<ItemPedidoEntity, Long> {
  ItemPedidoEntity findByPedidoAndItem(PedidoEntity pedido, ItemEntity item);

  List<ItemPedidoEntity> findByPedido(PedidoEntity pedido);

}
