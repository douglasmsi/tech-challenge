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
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private ItemEntity item;

    @OneToOne
    private PedidoEntity pedido;

    @Column
    private Integer quantidade;

    @Column
    private BigDecimal valor;

    @Column
    private String observacao;
}
