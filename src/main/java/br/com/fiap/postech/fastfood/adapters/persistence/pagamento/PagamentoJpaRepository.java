package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {

  List<PagamentoEntity> findAllByStatus(PagamentoStatus status);

  PagamentoEntity findByNumeroPedido(String numeroPedido);



}
