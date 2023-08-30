package br.com.fiap.postech.fastfood.usecases.item;

import br.com.fiap.postech.fastfood.domain.item.Item;

public interface CriarItemUseCase {
  Item save(Item item);
}
