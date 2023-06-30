package br.com.fiap.postech.fastfood.mock;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagamentoEntityMock {

    public static PagamentoEntity criaPagamentoEntity() {
        var pagamento = new PagamentoEntity();
        pagamento.setStatus(PagamentoStatus.PENDENTE);
        return pagamento;
    }

}
