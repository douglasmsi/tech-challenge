package br.com.fiap.postech.fastfood.usecases.item.impl;

import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.usecases.item.BuscarItemUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuscarItemUseCaseImpl implements BuscarItemUseCase {
  private final ItemPersistencePort itemPersistencePort;

  @Override
  public List<Item> findAll() {
    return itemPersistencePort.findAll();
  }

  @Override
  public Item findById(Long id) {
    return itemPersistencePort.findById(id);
  }

  @Override
  public List<Item> findAllByCategoria(CategoriaItem categoriaItem) {
    return itemPersistencePort.findAllByCategoria(categoriaItem);
  }
}
