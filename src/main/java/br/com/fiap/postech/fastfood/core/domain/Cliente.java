package br.com.fiap.postech.fastfood.core.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private List<Pedido> pedidos;
    private List<MetodoPagamento> metodosPagamento;

}
