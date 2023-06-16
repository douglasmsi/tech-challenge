package br.com.fiap.postech.fastfood.adapters.persistence.pedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoPersistencePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoPersistencePortImpl implements PedidoPersistencePort {

    private final PedidoJpaRepository pedidoJpaRepository;

    private final ModelMapper modelMapper;

    @Override
    public Pedido save(final Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoJpaRepository.save(modelMapper.map(pedido, PedidoEntity.class));
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pedido.class)).collect(Collectors.toList());
    }

    @Override
    public Pedido findByNumeroPedido(String numeroPedido) {
        return pedidoJpaRepository.findByNumeroPedido(numeroPedido);
    }

}