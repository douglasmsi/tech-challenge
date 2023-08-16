package br.com.fiap.postech.fastfood.ports.pedido;

import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.repository.cliente.ClienteJpaRepository;
import br.com.fiap.postech.fastfood.repository.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.repository.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.repository.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.repository.pagamento.PagamentoJpaRepository;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
import br.com.fiap.postech.fastfood.usecases.pedido.PedidoNumberGenerator;
import br.com.fiap.postech.fastfood.usecases.pedido.impl.PedidoNumberGeneratorImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoPersistencePortImpl implements PedidoPersistencePort {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final ItemJpaRepository itemJpaRepository;
    private final ClienteJpaRepository clienteJpaRepository;
    private final PagamentoJpaRepository pagamentoJpaRepository;


    private final ModelMapper modelMapper;


    @Override
    public Pedido createPedido(final Cliente request) {
        PedidoNumberGenerator generator = new PedidoNumberGeneratorImpl();
        String numeroPedido = generator.generateNumber();

        Pedido pedido = Pedido.builder()
            .cpf(request.getCpf())
            .numeroPedido(numeroPedido)
            .statusPagamento(PagamentoStatus.PENDENTE)
            .statusPedido(PedidoStatus.CRIADO)
            .build();

        ClienteEntity clienteEntity = clienteJpaRepository.findByCpf(pedido.getCpf());
        if (clienteEntity != null) {

            PedidoEntity pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
            pedidoEntity.setCliente(clienteEntity);

            pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
            return modelMapper.map(pedidoEntity, Pedido.class);
        }
        return null;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pedido.class)).toList();
    }

    @Override
    public Pedido findByNumeroPedido(String numeroPedido) {
        PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
        if(pedidoEntity == null) {
            return null;
        }
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

    @Override
    public Pedido updateStatusPedido(UpdatePedidoRequest request) {
        PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(request.getNumeroPedido());

        if (pedidoEntity == null) {
            return null;
        }

        pedidoEntity.setPedidoStatus(request.getStatusPedido());
        // Verifique se o novo status do pedido é CANCELADO
        if (request.getStatusPedido() == PedidoStatus.CANCELADO) {
            // Recupere o Pagamento associado
            PagamentoEntity pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(request.getNumeroPedido());

            // Atualize o status do Pagamento para ESTORNADO
            pagamentoEntity.setStatus(PagamentoStatus.ESTORNADO);
            pagamentoJpaRepository.save(pagamentoEntity);
            pedidoEntity.setPagamentoStatus(PagamentoStatus.ESTORNADO);
        }


        pedidoEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(pedidoEntity, Pedido.class);
    }

}
