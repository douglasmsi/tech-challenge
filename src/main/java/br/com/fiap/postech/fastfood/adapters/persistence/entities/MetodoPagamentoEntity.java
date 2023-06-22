package br.com.fiap.postech.fastfood.adapters.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metodo_pagamentos")
public class MetodoPagamentoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  private String cvv;
  private String numeroCartao;
  private String dataExpiracao;

  @OneToMany(mappedBy = "metodoPagamento")
  private List<PagamentoEntity> pagamentos;

}
