package br.com.fiap.postech.fastfood.repository.cliente;

import br.com.fiap.postech.fastfood.repository.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByCpf(final String cpf);

}
