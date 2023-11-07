package br.com.fiap.postech.fastfood.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metodo_pagamentos", uniqueConstraints = {@UniqueConstraint(columnNames = "numero_cartao")})
public class MetodoPagamentoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "cvv")
  private String cvv;

  @Column(name = "numero_cartao", unique = true)
  private String numeroCartao;

  @Column(name = "data_expiracao")
  private String dataExpiracao;

  @Column(name = "cpf")
  private String cpf;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private ClienteEntity cliente;

  @OneToMany(mappedBy = "metodoPagamento")
  private List<PagamentoEntity> pagamentos;

}
