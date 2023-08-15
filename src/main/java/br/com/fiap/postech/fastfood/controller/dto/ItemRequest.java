package br.com.fiap.postech.fastfood.controller.dto;


import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemRequest {

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String categoria;
}
