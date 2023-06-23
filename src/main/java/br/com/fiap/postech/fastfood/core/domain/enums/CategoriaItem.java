package br.com.fiap.postech.fastfood.core.domain.enums;

public enum CategoriaItem {

    BEBIDA("BEBIDA"),
    LANCHE("LANCHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    SOBREMESA("SOBREMESA");

    private String value;

    CategoriaItem(final String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
