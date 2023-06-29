package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.MetodoPagamentoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MetodoPagamentoJpaRepository extends JpaRepository<MetodoPagamentoEntity, Long> {

  List<MetodoPagamentoEntity> findByCpf(String cpf);

}
