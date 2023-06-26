package br.com.fiap.postech.fastfood.adapters.persistence.entities;

import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagamentos")
public class PagamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "status")
  private PagamentoStatus status;

  @Column
  private String numeroPedido;

  @OneToOne(mappedBy = "pagamentoEntity")
  private PedidoEntity pedido;


  @ManyToOne
  @JoinColumn(name = "metodo_pagamento_id")
  private MetodoPagamentoEntity metodoPagamento;


  @OneToOne(mappedBy = "pagamentoEntity", orphanRemoval = true)
  private PedidoEntity pedidoEntity;

  @Override
  public String toString() {
    return "PagamentoEntity{" +
        "id=" + id +
        ", status=" + status +
        ", numeroPedido='" + numeroPedido + '\'' +
        ", pedido=" + (pedido != null ? pedido.getNumeroPedido() : null) + // Evita a recursão infinita
        ", metodoPagamento=" + (metodoPagamento != null ? metodoPagamento.getId() : null) + // Evita a recursão infinita
        '}';
  }


}
