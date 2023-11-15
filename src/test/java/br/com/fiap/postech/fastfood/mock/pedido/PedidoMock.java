package br.com.fiap.postech.fastfood.mock.pedido;

import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;

@UtilityClass
public final class PedidoMock {

    public Pedido create() {
        return Pedido.builder().cpf("Cpf")
                .dataAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay())
                .dataPedido(LocalDate.of(1970, 1, 1).atStartOfDay())
                .items(new ArrayList<>())
                .numeroPedido("Numero Pedido")
                .statusPagamento(PagamentoStatus.PENDENTE)
                .statusPedido(PedidoStatus.CRIADO).build();
    }

}
