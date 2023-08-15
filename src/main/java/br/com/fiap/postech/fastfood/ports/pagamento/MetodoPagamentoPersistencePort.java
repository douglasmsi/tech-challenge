package br.com.fiap.postech.fastfood.ports.pagamento;

import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import java.util.List;

public interface MetodoPagamentoPersistencePort {

  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);
  MetodoPagamento findByIdAndCPF(Long id, String cpf);

  List<MetodoPagamento> findByCpf(String cpf);

  MetodoPagamento deleteByIdAndCPF(Long id, String cpf);
}
