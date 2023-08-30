package br.com.fiap.postech.fastfood.usecases.itempedido;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import java.util.List;

public interface BuscarItemPedidoUseCase {
  List<ItemPedido> findByNumeroPedido(String numeroPedido);
  List<ItemPedido> findAll();
}
