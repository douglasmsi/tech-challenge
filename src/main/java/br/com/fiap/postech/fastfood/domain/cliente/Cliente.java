package br.com.fiap.postech.fastfood.domain.cliente;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
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
