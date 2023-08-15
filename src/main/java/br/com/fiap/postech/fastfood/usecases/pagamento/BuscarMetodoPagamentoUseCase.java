package br.com.fiap.postech.fastfood.usecases.pagamento;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import java.util.List;

public interface BuscarMetodoPagamentoUseCase {
  MetodoPagamento findByIdAndCPF(Long id, String cpf);
  List<MetodoPagamento> findByCpf(String cpf);
}

