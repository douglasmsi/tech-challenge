package br.com.fiap.postech.fastfood.usecases.pagamento.impl;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.usecases.pagamento.DeletarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletarMetodoPagamentoUseCaseImpl implements DeletarMetodoPagamentoUseCase {
  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento deleteByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoPersistencePort.deleteByIdAndCPF(id, cpf);
  }
}

