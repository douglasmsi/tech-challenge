package br.com.fiap.postech.fastfood.domain.enums;

public enum CategoriaItem {

    BEBIDA("BEBIDA"),
    LANCHE("LANCHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    SOBREMESA("SOBREMESA");

    private String value;

    CategoriaItem(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
