package br.com.fiap.postech.fastfood.adapters.persistence.cliente;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import io.micrometer.core.instrument.binder.db.MetricsDSLContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
    Cliente findByCpf(final String cpf);
}
