package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {

  List<PagamentoEntity> findAllByStatus(final PagamentoStatus status);

}
