package br.com.fiap.postech.fastfood.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedido {

    private Item item;
    private Integer quantidade;
    private BigDecimal valor;
    private String observacao;

    @JsonBackReference
    private Pedido pedido;

    public BigDecimal getValor() {
        return this.item.getValor().multiply(BigDecimal.valueOf(this.quantidade));
    }

}
