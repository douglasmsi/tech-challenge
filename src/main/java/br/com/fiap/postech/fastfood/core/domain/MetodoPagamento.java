package br.com.fiap.postech.fastfood.core.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPagamento {

  private Long id;
  private String cvv;
  private String dataExpiracao;
  private String numeroCartao;

}
