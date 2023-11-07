package br.com.fiap.postech.fastfood.repository.pagamento;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.repository.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {

  List<PagamentoEntity> findAllByStatus(PagamentoStatus status);

  PagamentoEntity findByNumeroPedido(String numeroPedido);



}
