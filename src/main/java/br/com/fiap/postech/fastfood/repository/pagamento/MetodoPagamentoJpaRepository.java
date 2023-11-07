package br.com.fiap.postech.fastfood.repository.pagamento;

import br.com.fiap.postech.fastfood.repository.entities.MetodoPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MetodoPagamentoJpaRepository extends JpaRepository<MetodoPagamentoEntity, Long> {

  List<MetodoPagamentoEntity> findByCpf(String cpf);

}
