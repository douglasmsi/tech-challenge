package br.com.fiap.postech.fastfood.ports.itempedido;

import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.repository.entities.ItemEntity;
import br.com.fiap.postech.fastfood.repository.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.repository.entities.PedidoEntity;
import br.com.fiap.postech.fastfood.repository.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.repository.itempedido.ItemPedidoJpaRepository;
import br.com.fiap.postech.fastfood.repository.pedido.PedidoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ItemPedidoPersistencePortImpl implements ItemPedidoPersistencePort {

  private final ItemPedidoJpaRepository itemPedidoJpaRepository;
  private final PedidoJpaRepository pedidoJpaRepository;
  private final ItemJpaRepository itemJpaRepository;
  private final ModelMapper modelMapper;

  @Override
  public ItemPedido addItemPedido(String numeroPedido, Item item, Integer quantidade) {
    PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
    ItemEntity itemEntity = itemJpaRepository.findById(item.getId())
            .orElse(null);

    if (pedidoEntity == null || itemEntity == null) {
      // Lógica de tratamento caso o pedido ou item não sejam encontrados
      return null;
    }

    ItemPedidoEntity itemPedidoEntity = itemPedidoJpaRepository.findByPedidoAndItem(pedidoEntity, itemEntity);

    if (itemPedidoEntity != null) {
      // Já existe um ItemPedidoEntity para o mesmo pedido e item, então atualize a quantidade e o valor
      itemPedidoEntity.setQuantidade(quantidade);
      itemPedidoEntity.setValor(item.getValor());
    } else {
      // Não existe um ItemPedidoEntity, crie um novo
      itemPedidoEntity = new ItemPedidoEntity();
      itemPedidoEntity.setPedido(pedidoEntity);
      itemPedidoEntity.setItem(itemEntity);
      itemPedidoEntity.setQuantidade(quantidade);
      itemPedidoEntity.setValor(item.getValor());

    }
    itemPedidoJpaRepository.save(itemPedidoEntity);
    return modelMapper.map(itemPedidoEntity, ItemPedido.class);
  }

  @Override
  public ItemPedido updateItemPedido(ItemPedido itemPedido) {
    return null;
  }

  @Override
  public ItemPedido deleteItemPedido(ItemPedido itemPedido) {
    return null;
  }

  @Override
  public List<ItemPedido> findAll() {
    return itemPedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, ItemPedido.class)).toList();
  }

  @Override
  public List<ItemPedido> findByNumeroPedido(String numeroPedido) {
    PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
    if (pedidoEntity == null) {
      // Lógica de tratamento caso o pedido não seja encontrado
      return null;
    }
    return itemPedidoJpaRepository.findByPedido(pedidoEntity).stream().map(entity -> modelMapper.map(entity, ItemPedido.class)).toList();
  }
}
