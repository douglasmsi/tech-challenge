package br.com.fiap.postech.fastfood.usecases.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;

public interface AtualizarClienteUseCase {

  Cliente save(Cliente cliente);
}
