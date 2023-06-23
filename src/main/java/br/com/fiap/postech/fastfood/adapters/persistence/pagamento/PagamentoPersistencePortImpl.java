package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoPersistencePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PagamentoPersistencePortImpl implements PagamentoPersistencePort {

  private final PagamentoJpaRepository pagamentoJpaRepository;
  private final ModelMapper modelMapper;

  @Override
  public Pagamento save(final Pagamento pagamento) {
    var pagamentoEntity = pagamentoJpaRepository.save(modelMapper.map(pagamento, PagamentoEntity.class));
    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pagamento.class)).toList();
  }

  @Override
  public Pagamento findById(final Long id) {
    return pagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, Pagamento.class)).orElse(null);
  }

  @Override
  public Pagamento updateStatusPagamento(final Pagamento pagamento) {
    var pagamentoEntity = pagamentoJpaRepository.saveAndFlush(modelMapper.map(pagamento, PagamentoEntity.class));
    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
  public List<Pagamento> findAllByStatus(final PagamentoStatus status) {
    return pagamentoJpaRepository.findAllByStatus(status).stream().map(entity -> modelMapper.map(entity, Pagamento.class)).toList();
  }

}
