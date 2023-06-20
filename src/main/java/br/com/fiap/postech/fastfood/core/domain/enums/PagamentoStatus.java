package br.com.fiap.postech.fastfood.core.domain.enums;

public enum PagamentoStatus {

    PENDENTE("PENDENTE"),
    APROVADO("APROVADO"),
    NEGADO("NEGADO"),
    ESTORNADO("ESTORNADO");

    private String value;

    PagamentoStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
