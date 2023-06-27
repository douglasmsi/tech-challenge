package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

import static java.util.Objects.nonNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    String numeroPedido;
    PedidoStatus statusPedido;
    PagamentoStatus statusPagamento;
    BigDecimal valorTotal;
    String cpf;

    @JsonManagedReference
    List<ItemPedido> items;

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        if (nonNull(items)) {
            for (ItemPedido item : items) {
                total = total.add(item.getValor());
            }
        }
        return total;
    }

}
