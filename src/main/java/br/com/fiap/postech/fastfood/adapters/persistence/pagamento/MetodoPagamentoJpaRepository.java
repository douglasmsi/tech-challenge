package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.MetodoPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MetodoPagamentoJpaRepository extends JpaRepository<MetodoPagamentoEntity, Long> {

  MetodoPagamentoEntity findByIdAndCpf(Long id, String cpf);

  MetodoPagamentoEntity deleteByIdAndCpf(Long id, String cpf);

}
