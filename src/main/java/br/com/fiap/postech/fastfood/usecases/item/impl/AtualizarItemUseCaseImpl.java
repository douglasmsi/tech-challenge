package br.com.fiap.postech.fastfood.usecases.item.impl;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.usecases.item.AtualizarItemUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarItemUseCaseImpl implements AtualizarItemUseCase {
  private final ItemPersistencePort itemPersistencePort;

  @Override
  public Item save(Item item) {
    return itemPersistencePort.save(item);
  }
}
