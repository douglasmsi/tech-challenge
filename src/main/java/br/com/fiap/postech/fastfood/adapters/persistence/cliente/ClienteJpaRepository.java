package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import io.micrometer.core.instrument.binder.db.MetricsDSLContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findByCpf(final String cpf);
}
