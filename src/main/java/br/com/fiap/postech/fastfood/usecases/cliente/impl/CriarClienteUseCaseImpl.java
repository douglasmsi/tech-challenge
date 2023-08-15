package br.com.fiap.postech.fastfood.usecases.cliente.impl;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.usecases.cliente.CriarClienteUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarClienteUseCaseImpl implements CriarClienteUseCase {

  private final ClientePersistencePort clientePersistencePort;

  @Override
  public Cliente save(Cliente cliente) {
    return clientePersistencePort.save(cliente);
  }
}
