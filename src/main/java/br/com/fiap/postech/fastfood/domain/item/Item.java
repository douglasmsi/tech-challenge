package br.com.fiap.postech.fastfood.domain.item;

import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private CategoriaItem categoria;

}
