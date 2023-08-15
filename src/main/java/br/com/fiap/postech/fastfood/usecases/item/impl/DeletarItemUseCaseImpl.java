package br.com.fiap.postech.fastfood.usecases.item.impl;

import br.com.fiap.postech.fastfood.ports.item.ItemPersistencePort;
import br.com.fiap.postech.fastfood.usecases.item.DeletarItemUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletarItemUseCaseImpl implements DeletarItemUseCase {
  private final ItemPersistencePort itemPersistencePort;

  @Override
  public void deletarItem(Long id) {
    itemPersistencePort.deletarItem(id);
  }
}
