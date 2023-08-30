package br.com.fiap.postech.fastfood.usecases.pedido;

import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;

public interface AtualizarPedidoUseCase {
  Pedido updateStatusPedido(UpdatePedidoRequest pedido);
}
