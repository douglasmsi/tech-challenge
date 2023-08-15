package br.com.fiap.postech.fastfood.domain.pedido;

import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
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
    String cpf;


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
