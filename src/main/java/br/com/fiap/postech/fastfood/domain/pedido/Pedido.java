package br.com.fiap.postech.fastfood.domain.pedido;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    LocalDateTime dataPedido;
    LocalDateTime dataAtualizacao;

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
