package br.com.fiap.postech.fastfood.repository.pagamento;

import br.com.fiap.postech.fastfood.repository.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.ports.pagamento.PagamentoPersistencePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PagamentoPersistencePortImpl implements PagamentoPersistencePort {

  private final PagamentoJpaRepository pagamentoJpaRepository;
  private final PedidoJpaRepository pedidoJpaRepository;
  private final ModelMapper modelMapper;

  @Override
    public Pagamento save(Pagamento pagamento) {
    PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(pagamento.getPedido().getNumeroPedido());

    if (pedidoEntity == null) {
      throw new RuntimeException("Pedido não encontrado");
    }

    PagamentoEntity pagamentoEntity = modelMapper.map(pagamento, PagamentoEntity.class);
    pagamentoEntity.setPedido(pedidoEntity);
    pedidoEntity.setPagamentoEntity(pagamentoEntity);
    pagamentoEntity = pagamentoJpaRepository.save(pagamentoEntity);

    pedidoEntity.setPagamentoStatus(pagamentoEntity.getStatus());

    pedidoJpaRepository.saveAndFlush(pedidoEntity);
    pagamentoJpaRepository.saveAndFlush(pagamentoEntity);

    return modelMapper.map(pagamentoEntity, Pagamento.class);
    }

    @Override
    public List<Pagamento> findAll() {
      return pagamentoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pagamento.class)).collect(
          java.util.stream.Collectors.toList());
    }

    @Override
    public Pagamento findById(Long id) {
      return pagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, Pagamento.class)).orElse(null);
    }

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    PagamentoEntity pagamentoEntity = pagamentoJpaRepository.saveAndFlush(modelMapper.map(pagamento, PagamentoEntity.class));
    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
    public List<Pagamento> findAllByStatus(PagamentoStatus status) {
      return pagamentoJpaRepository.findAllByStatus(status).stream().map(entity -> modelMapper.map(entity, Pagamento.class)).collect(
          java.util.stream.Collectors.toList());
    }


  @Override
  public PagamentoStatus getStatusPagamento(String numeroPedido) {
    PagamentoEntity pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(numeroPedido);
    return pagamentoEntity.getStatus();
  }



}
