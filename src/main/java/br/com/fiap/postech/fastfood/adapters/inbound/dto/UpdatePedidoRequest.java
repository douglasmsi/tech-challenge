package br.com.fiap.postech.fastfood.adapters.inbound.dto;

import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdatePedidoRequest {

    private String numeroPedido;
    private PedidoStatus statusPedido;
    private String cpf;
}
