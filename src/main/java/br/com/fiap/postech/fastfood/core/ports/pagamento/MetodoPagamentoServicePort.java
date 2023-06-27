package br.com.fiap.postech.fastfood.core.ports.pagamento;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import java.util.List;

public interface MetodoPagamentoServicePort {

  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);
  MetodoPagamento findByIdAndCPF(Long id, String cpf);

  List<MetodoPagamento> findAllByCPF(String cpf);

  MetodoPagamento deleteByIdAndCPF(Long id, String cpf);
}
