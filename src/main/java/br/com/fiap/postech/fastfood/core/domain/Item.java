package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private CategoriaItem categoria;

}
