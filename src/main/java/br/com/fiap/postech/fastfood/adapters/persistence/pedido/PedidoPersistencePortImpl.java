package br.com.fiap.postech.fastfood.adapters.persistence.pedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import br.com.fiap.postech.fastfood.core.utils.PedidoNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoPersistencePortImpl implements PedidoPersistencePort {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final ItemJpaRepository itemJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Pedido createPedido(final Pedido pedido) {
        var numeroPedido = PedidoNumberGenerator.generateNumber();
        pedido.setNumeroPedido(numeroPedido);
        pedido.setStatusPagamento(PagamentoStatus.PENDENTE);
        pedido.setStatusPedido(PedidoStatus.CRIADO);
        PedidoEntity pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
        pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pedido.class)).toList();
    }

    @Override
    public Pedido findByNumeroPedido(final String numeroPedido) {
        var pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public Pedido updateStatusPedido(final Pedido pedido) {
        var pedidoEntity = pedidoJpaRepository.findByNumeroPedido(pedido.getNumeroPedido());
        pedidoEntity.setPedidoStatus(pedido.getStatusPedido());
        pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

}