package br.com.fiap.postech.fastfood.mock.pagamento;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.repository.entities.PagamentoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class PagamentoEntityMock {

    public PagamentoEntity criaPagamentoEntity() {
        var pagamento = new PagamentoEntity();
        pagamento.setStatus(PagamentoStatus.PENDENTE);
        return pagamento;
    }

}
