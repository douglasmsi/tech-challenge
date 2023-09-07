package br.com.fiap.postech.fastfood.usecases.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;

import java.util.List;

public interface BuscarClienteUseCase {
  List<Cliente> findAll();
  Cliente findByCpf(String cpf);
  Cliente findByNome(String nome);
}
