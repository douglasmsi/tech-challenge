package br.com.fiap.postech.fastfood.mock.pedido;

import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public final class PedidoEntityMock {

    public PedidoEntity criaPedidoEntity() {
        var pedido = new PedidoEntity();
        pedido.setNumeroPedido("123456");
        pedido.setPedidoStatus(PedidoStatus.CRIADO);
        pedido.setValorTotal(BigDecimal.TEN);
        return pedido;
    }

}
