package br.com.fiap.postech.fastfood.adapters.persistence.entities;

import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
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
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String numeroPedido;

    @Column
    private PedidoStatus status;

    @Column
    private BigDecimal valorTotal;

    @ManyToOne
    private ClienteEntity cliente;

}