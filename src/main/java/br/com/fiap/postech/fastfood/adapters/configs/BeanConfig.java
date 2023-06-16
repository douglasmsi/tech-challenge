package br.com.fiap.postech.fastfood.adapters.configs;

import br.com.fiap.postech.fastfood.FastfoodApplication;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.services.cliente.ClienteServicePortImpl;
import br.com.fiap.postech.fastfood.core.services.pedido.PedidoServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = FastfoodApplication.class)
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ClienteServicePortImpl clienteServicePortImpl(ClientePersistencePort persistence) {
        return new ClienteServicePortImpl(persistence);
    }

    @Bean
    public PedidoServicePortImpl pedidoServicePortImpl(PedidoPersistencePort persistence) {
        return new PedidoServicePortImpl(persistence);
    }

}
