package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
