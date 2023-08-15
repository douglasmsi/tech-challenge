package br.com.fiap.postech.fastfood.usecases.item;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;

import java.util.List;

public interface BuscarItemUseCase {
  List<Item> findAll();
  Item findById(Long id);
  List<Item> findAllByCategoria(CategoriaItem categoriaItem);
}
