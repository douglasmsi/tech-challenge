package br.com.fiap.postech.fastfood.adapters.configs;

import br.com.fiap.postech.fastfood.core.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.core.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.services.cliente.ClienteServicePortImpl;
import br.com.fiap.postech.fastfood.core.services.item.ItemServicePortImpl;
import br.com.fiap.postech.fastfood.core.services.itempedido.ItemPedidoServicePortImpl;
import br.com.fiap.postech.fastfood.core.services.pagamento.PagamentoServicePortImpl;
import br.com.fiap.postech.fastfood.core.services.pedido.PedidoServicePortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ClienteServicePortImpl clienteServicePortImpl(final ClientePersistencePort persistence) {
        return new ClienteServicePortImpl(persistence);
    }

    @Bean
    public PedidoServicePortImpl pedidoServicePortImpl(final PedidoPersistencePort persistence) {
        return new PedidoServicePortImpl(persistence);
    }

    @Bean
    public ItemServicePortImpl itemServicePortImpl(final ItemPersistencePort persistence) {
        return new ItemServicePortImpl(persistence);
    }

    @Bean
    public PagamentoServicePortImpl pagamentoServicePortImpl(final PagamentoPersistencePort persistence) {
        return new PagamentoServicePortImpl(persistence);
    }

    @Bean
    public ItemPedidoServicePortImpl itemPedidoServicePortImpl(final ItemPedidoPersistencePort persistence) {
        return new ItemPedidoServicePortImpl(persistence);
    }

}
