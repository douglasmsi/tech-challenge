package br.com.fiap.postech.fastfood.core.domain;

import br.com.fiap.postech.fastfood.core.utils.ObjectMapperUtils;

public abstract class JsonAbstract {

    @Override
    public String toString() {
        return ObjectMapperUtils.classToJson(this);
    }

}
