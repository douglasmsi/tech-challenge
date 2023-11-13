package br.com.fiap.postech.fastfood.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String categoria;
}
