package br.com.fiap.postech.fastfood.core.domain.enums;

public enum PedidoStatus {

    CRIADO("CRIADO"),
    ANDAMENTO("ANDAMENTO"),
    ENTREGA("ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private String value;

    PedidoStatus(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }



}
