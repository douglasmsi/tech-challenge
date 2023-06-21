package br.com.fiap.postech.fastfood.core.domain.enums;

public enum PagamentoStatus {

    PENDENTE("PENDENTE"),
    APROVADO("APROVADO"),
    NEGADO("NEGADO"),
    ESTORNADO("ESTORNADO");

    private String value;

    PagamentoStatus(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
