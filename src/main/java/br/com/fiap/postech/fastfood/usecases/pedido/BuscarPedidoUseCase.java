package br.com.fiap.postech.fastfood.usecases.pedido;

import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import java.util.List;

public interface BuscarPedidoUseCase {
  List<Pedido> findAll();
  Pedido findByNumeroPedido(String numeroPedido);
}
