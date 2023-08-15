package br.com.fiap.postech.fastfood.repository.pedido;

import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    PedidoEntity findByNumeroPedido(String numeroPedido);



}