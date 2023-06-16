package br.com.fiap.postech.fastfood.adapters.persistence.pedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    Pedido findByNumeroPedido(final String numeroPedido);

}