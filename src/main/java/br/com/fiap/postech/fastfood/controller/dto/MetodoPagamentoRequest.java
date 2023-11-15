package br.com.fiap.postech.fastfood.controller.dto;

import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MetodoPagamentoRequest {

  private MetodoPagamento metodoPagamento;
}
