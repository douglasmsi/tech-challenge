package br.com.fiap.postech.fastfood.adapters.persistence.pagamento;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.MetodoPagamentoEntity;
import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import br.com.fiap.postech.fastfood.core.ports.pagamento.MetodoPagamentoPersistencePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MetodoPagamentoPersistencePortImpl implements MetodoPagamentoPersistencePort {

  private final ModelMapper modelMapper;
  private final MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;
  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest request) {

    MetodoPagamento metodoPagamento = MetodoPagamento.builder()
        .cvv(request.getMetodoPagamento().getCvv())
        .numeroCartao(request.getMetodoPagamento().getNumeroCartao())
        .dataExpiracao(request.getMetodoPagamento().getDataExpiracao()).
        build();

    MetodoPagamentoEntity metodoPagamentoEntity = modelMapper.map(metodoPagamento, MetodoPagamentoEntity.class);
    metodoPagamentoEntity = metodoPagamentoJpaRepository.save(metodoPagamentoEntity);
    return modelMapper.map(metodoPagamentoEntity, MetodoPagamento.class);
  }

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, MetodoPagamento.class)).orElse(null);
  }

  @Override
  public List<MetodoPagamento> findAllByCPF(String cpf) {
    return metodoPagamentoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, MetodoPagamento.class)).collect(
        java.util.stream.Collectors.toList());
  }

  @Override
  public MetodoPagamento deleteByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> {
      metodoPagamentoJpaRepository.deleteById(id);
      return modelMapper.map(entity, MetodoPagamento.class);
    }).orElse(null);
  }
}
