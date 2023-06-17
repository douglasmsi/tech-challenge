package br.com.fiap.postech.fastfood.core.domain.enums;

public enum PedidoStatus {

    CRIADO("CRIADO"),
    ANDAMENTO("ANDAMENTO"),
    ENTREGA("ENTREGA"),
    FINALIZADO("FINALIZADO");

    private String value;

    PedidoStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}