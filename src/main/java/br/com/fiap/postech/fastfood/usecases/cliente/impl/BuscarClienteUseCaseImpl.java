package br.com.fiap.postech.fastfood.usecases.cliente.impl;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.ports.cliente.ClientePersistencePort;
import br.com.fiap.postech.fastfood.usecases.cliente.BuscarClienteUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {
  private final ClientePersistencePort clientePersistencePort;

  @Override
  public List<Cliente> findAll() {
    return clientePersistencePort.findAll();
  }

  @Override
  public Cliente findByCpf(String cpf) {
    return clientePersistencePort.findByCpf(cpf);
  }

  @Override
  public Cliente findByNome(String nome) {
    return clientePersistencePort.findByNome(nome);
  }
}
