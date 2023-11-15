package br.com.fiap.postech.fastfood.domain.pagamento;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

  private Long id;
  private Pedido pedido;
  private PagamentoStatus status;
  private MetodoPagamento metodoPagamento;
}
