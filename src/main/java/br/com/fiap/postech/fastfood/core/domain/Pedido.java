package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    String numeroPedido;
    PedidoStatus statusPedido;
    PagamentoStatus statusPagamento;
    BigDecimal valorTotal;

    @JsonManagedReference
    List<ItemPedido> items;

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        if (items != null) {
            for (ItemPedido item : items) {
                total = total.add(item.getValor());
            }
        }
        return total;
    }

}
