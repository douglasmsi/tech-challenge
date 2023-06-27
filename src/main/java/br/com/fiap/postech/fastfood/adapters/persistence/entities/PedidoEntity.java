package br.com.fiap.postech.fastfood.adapters.persistence.entities;

import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos", uniqueConstraints = {@UniqueConstraint(columnNames = "numeroPedido")})
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String numeroPedido;

    @Column
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column
    private PedidoStatus pedidoStatus;

    @Enumerated(EnumType.STRING)
    @Column
    private PagamentoStatus pagamentoStatus;

    @Column
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedidoEntity> items;

    @OneToOne
    @JoinColumn(name = "pagamento_entity_id")
    private PagamentoEntity pagamentoEntity;

    @Override
    public String toString() {
        return "PedidoEntity{" +
            "id=" + id +
            ", numeroPedido='" + numeroPedido + '\'' +
            ", cpf='" + cpf + '\'' +
            ", pedidoStatus=" + pedidoStatus +
            ", pagamentoStatus=" + pagamentoStatus +
            ", valorTotal=" + valorTotal +
            ", cliente=" + (cliente != null ? cliente.getId() : null) + // Evita a recursão infinita
            ", items=" + items +
            ", pagamentoEntity=" + (pagamentoEntity != null ? pagamentoEntity.getId() : null) + // Evita a recursão infinita
            '}';
    }

}