package br.com.fiap.postech.fastfood.adapters.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEM_PEDIDO")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer quantidade;

    @Column
    private BigDecimal valor;

    @Column
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "item_id") // Nome da coluna de associação com a tabela item
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "pedido_id") // Nome da coluna de associação com a tabela pedido
    private PedidoEntity pedido;

    @Override
    public String toString() {
        return "ItemPedidoEntity{" +
            "id=" + id +
            ", quantidade=" + quantidade +
            ", valor=" + valor +
            ", observacao='" + observacao + '\'' +
            ", item=" + (item != null ? item.getId() : null) + // Evita a recursão infinita
            ", pedido=" + (pedido != null ? pedido.getNumeroPedido() : null) + // Evita a recursão infinita
            '}';
    }

}
