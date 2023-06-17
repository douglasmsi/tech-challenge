package br.com.fiap.postech.fastfood.core.services.item;

import br.com.fiap.postech.fastfood.core.ports.item.ItemPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class ItemServicePortImpl {

  private final ItemPersistencePort itemPersistencePort;
}
