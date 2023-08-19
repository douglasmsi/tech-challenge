package br.com.fiap.postech.fastfood.config;

import br.com.fiap.postech.fastfood.FastfoodApplication;
import br.com.fiap.postech.fastfood.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.ports.itempedido.ItemPedidoPersistencePort;
import br.com.fiap.postech.fastfood.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.cliente.BuscarClienteUseCase;
import br.com.fiap.postech.fastfood.usecases.cliente.CriarClienteUseCase;
import br.com.fiap.postech.fastfood.usecases.cliente.impl.BuscarClienteUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.cliente.impl.CriarClienteUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.item.impl.AtualizarItemUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.item.impl.BuscarItemUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.item.impl.CriarItemUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.item.impl.DeletarItemUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.itempedido.AdicionarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.AtualizarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.BuscarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.DeletarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.impl.AdicionarItemPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.itempedido.impl.AtualizarItemPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.itempedido.impl.BuscarItemPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.itempedido.impl.DeletarItemPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.pagamento.*;
import br.com.fiap.postech.fastfood.usecases.pagamento.impl.*;
import br.com.fiap.postech.fastfood.usecases.pedido.impl.AtualizarPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.pedido.impl.BuscarPedidoParaEntregaUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.pedido.impl.BuscarPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.usecases.pedido.impl.CriarPedidoUseCaseImpl;
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
    public CriarClienteUseCase criarClienteUseCase(ClientePersistencePort persistence) {
        return new CriarClienteUseCaseImpl(persistence);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClientePersistencePort persistence) {
        return new BuscarClienteUseCaseImpl(persistence);
    }

    @Bean
    public CriarPedidoUseCaseImpl criarPedidoUseCaseImpl(PedidoPersistencePort persistence) {
        return new CriarPedidoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarPedidoUseCaseImpl buscarPedidoUseCaseImpl(PedidoPersistencePort persistence) {
        return new BuscarPedidoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarPedidoParaEntregaUseCaseImpl buscarPedidoParaEntregaUseCaseImpl(PedidoPersistencePort persistence) {
        return new BuscarPedidoParaEntregaUseCaseImpl(persistence);
    }

    @Bean
    public AtualizarPedidoUseCaseImpl atualizarPedidoUseCaseImpl(PedidoPersistencePort persistence) {
        return new AtualizarPedidoUseCaseImpl(persistence);
    }

    @Bean
    public CriarItemUseCaseImpl criarItemUseCaseImpl(ItemPersistencePort persistence) {
        return new CriarItemUseCaseImpl(persistence);
    }

    @Bean
    public AtualizarItemUseCaseImpl atualizarItemUseCaseImpl(ItemPersistencePort persistence) {
        return new AtualizarItemUseCaseImpl(persistence);
    }

    @Bean
    public BuscarItemUseCaseImpl buscarItemUseCaseImpl(ItemPersistencePort persistence) {
        return new BuscarItemUseCaseImpl(persistence);
    }

    @Bean
    public DeletarItemUseCaseImpl deletarItemUseCaseImpl(ItemPersistencePort persistence) {
        return new DeletarItemUseCaseImpl(persistence);
    }

    @Bean
    public CriarPagamentoUseCase criarPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new CriarPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarPagamentoUseCase buscarPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new BuscarPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new AtualizarStatusPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public AdicionarItemPedidoUseCase adicionarItemPedidoUseCase(ItemPedidoPersistencePort persistence) {
        return new AdicionarItemPedidoUseCaseImpl(persistence);
    }

    @Bean
    public AtualizarItemPedidoUseCase atualizarItemPedidoUseCase(ItemPedidoPersistencePort persistence) {
        return new AtualizarItemPedidoUseCaseImpl(persistence);
    }

    @Bean
    public DeletarItemPedidoUseCase deletarItemPedidoUseCase(ItemPedidoPersistencePort persistence) {
        return new DeletarItemPedidoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarItemPedidoUseCase buscarItemPedidoUseCase(ItemPedidoPersistencePort persistence) {
        return new BuscarItemPedidoUseCaseImpl(persistence);
    }


    @Bean
    public CriarMetodoPagamentoUseCase criarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new CriarMetodoPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new BuscarMetodoPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new DeletarMetodoPagamentoUseCaseImpl(persistence);
    }

}
