package br.com.fiap.postech.fastfood.core.services.pagamento;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import br.com.fiap.postech.fastfood.core.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.core.ports.pagamento.MetodoPagamentoServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MetodoPagamentoServicePortImpl implements MetodoPagamentoServicePort {

  private MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  public MetodoPagamentoServicePortImpl(MetodoPagamentoPersistencePort metodoPagamentoPersistencePort) {
    this.metodoPagamentoPersistencePort = metodoPagamentoPersistencePort;
  }

  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento) {
    return metodoPagamentoPersistencePort.createMetodoPagamento(metodoPagamento);
  }

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoPersistencePort.findByIdAndCPF(id, cpf);
  }

  @Override
  public List<MetodoPagamento> findByCpf(String cpf) {
    return metodoPagamentoPersistencePort.findByCpf(cpf);
  }

  @Override
  public MetodoPagamento deleteByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoPersistencePort.deleteByIdAndCPF(id, cpf);
  }
}
