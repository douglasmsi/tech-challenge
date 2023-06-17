package br.com.fiap.postech.fastfood.core.ports.item;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.Item;

import java.util.List;

public interface ItemServicePort {

    Item save(Cliente cliente);
    List<Item> findAll();
    Item findById(Long id);
}
