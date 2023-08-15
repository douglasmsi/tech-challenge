package br.com.fiap.postech.fastfood.repository.pagamento;

import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.repository.cliente.ClienteJpaRepository;
import br.com.fiap.postech.fastfood.repository.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.repository.entities.MetodoPagamentoEntity;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.MetodoPagamentoPersistencePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MetodoPagamentoPersistencePortImpl implements MetodoPagamentoPersistencePort {

  private final ModelMapper modelMapper;
  private final MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;
  private final ClienteJpaRepository clienteJpaRepository;
  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest request) {

    ClienteEntity cliente = clienteJpaRepository.findByCpf(request.getMetodoPagamento().getCpf());
    if (cliente == null) {
      return null;
    }


    MetodoPagamento metodoPagamento = MetodoPagamento.builder()
        .cvv(request.getMetodoPagamento().getCvv())
        .numeroCartao(request.getMetodoPagamento().getNumeroCartao())
        .dataExpiracao(request.getMetodoPagamento().getDataExpiracao())
        .cpf(request.getMetodoPagamento().getCpf())
        .build();

    MetodoPagamentoEntity metodoPagamentoEntity = modelMapper.map(metodoPagamento, MetodoPagamentoEntity.class);
    metodoPagamentoEntity.setCliente(cliente);
    metodoPagamentoEntity = metodoPagamentoJpaRepository.save(metodoPagamentoEntity);

    cliente.setMetodosPagamento(metodoPagamentoEntity.getCliente().getMetodosPagamento());
    clienteJpaRepository.saveAndFlush(cliente);

    return modelMapper.map(metodoPagamentoEntity, MetodoPagamento.class);
  }

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, MetodoPagamento.class)).orElse(null);
  }

  @Override
  public List<MetodoPagamento> findByCpf(String cpf) {
    return metodoPagamentoJpaRepository.findByCpf(cpf).stream().map(entity -> modelMapper.map(entity, MetodoPagamento.class)).toList();
  }

  @Override
  public MetodoPagamento deleteByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> {
      metodoPagamentoJpaRepository.deleteById(id);
      return modelMapper.map(entity, MetodoPagamento.class);
    }).orElse(null);
  }
}
