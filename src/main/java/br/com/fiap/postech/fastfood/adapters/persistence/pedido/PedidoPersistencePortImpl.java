package br.com.fiap.postech.fastfood.adapters.persistence.pedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.utils.PedidoNumberGenerator;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoPersistencePortImpl implements PedidoPersistencePort {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final ItemJpaRepository itemJpaRepository;


    private final ModelMapper modelMapper;


    @Override
    public Pedido createPedido(final Pedido pedido) {
        String numeroPedido = PedidoNumberGenerator.generateNumber();
        pedido.setNumeroPedido(numeroPedido);
        pedido.setStatusPagamento(PagamentoStatus.PENDENTE);
        pedido.setStatusPedido(PedidoStatus.CRIADO);
        PedidoEntity pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
        pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pedido.class)).collect(Collectors.toList());
    }

    @Override
    public Pedido findByNumeroPedido(String numeroPedido) {
        PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public Pedido updateStatusPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(pedido.getNumeroPedido());
        pedidoEntity.setPedidoStatus(pedido.getStatusPedido());
        pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

}