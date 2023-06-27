package br.com.fiap.postech.fastfood.adapters.persistence.itempedido;

import br.com.fiap.postech.fastfood.adapters.persistence.entities.ItemPedidoEntity;
import br.com.fiap.postech.fastfood.adapters.persistence.item.ItemJpaRepository;
import br.com.fiap.postech.fastfood.adapters.persistence.pedido.PedidoJpaRepository;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoPersistencePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Component
public class ItemPedidoPersistencePortImpl implements ItemPedidoPersistencePort {

  private final ItemPedidoJpaRepository itemPedidoJpaRepository;
  private final PedidoJpaRepository pedidoJpaRepository;
  private final ItemJpaRepository itemJpaRepository;
  private final ModelMapper modelMapper;

  @Override
  public ItemPedido addItemPedido(final String numeroPedido, final Item item, final Integer quantidade) {
    var pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
    var itemEntity = itemJpaRepository.findById(item.getId()).get();

    if (isNull(pedidoEntity) || isNull(itemEntity)) {
      // Lógica de tratamento caso o pedido ou item não sejam encontrados
      return null;
    }

    var itemPedidoEntity = itemPedidoJpaRepository.findByPedidoAndItem(pedidoEntity, itemEntity);

    if (nonNull(itemPedidoEntity)) {
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
  public ItemPedido updateItemPedido(final ItemPedido itemPedido) {
    return null;
  }

  @Override
  public ItemPedido deleteItemPedido(final ItemPedido itemPedido) {
    return null;
  }

  @Override
  public List<ItemPedido> findAll() {
    return itemPedidoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, ItemPedido.class)).toList();
  }

  @Override
  public List<ItemPedido> findByID(Long id) {
    return Collections.emptyList();
  }

  @Override
  public List<ItemPedido> findByNumeroPedido(String numeroPedido) {
    PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(numeroPedido);
    return itemPedidoJpaRepository.findByPedido(pedidoEntity).stream().map(entity -> modelMapper.map(entity, ItemPedido.class)).collect(
        java.util.stream.Collectors.toList());
  }

}
