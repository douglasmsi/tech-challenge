package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoServicePort;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("itempedidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemPedidoController {

  final ItemPedidoServicePort itemPedidoServicePort;

  @GetMapping(value = "/itempedidos", produces = "application/json")
  ResponseEntity<Object> getAllItemPedidos() {
    List<ItemPedido> itemPedidos = itemPedidoServicePort.findAll();
    return ResponseEntity.ok(itemPedidos);
  }

  @PostMapping(value = "/itempedidos")
  ResponseEntity<Object> addItemPedido(@RequestBody ItemPedidoRequest request) {
    System.out.println("numeroPedido: " + request.getNumeroPedido());
    ItemPedido itemPedido = itemPedidoServicePort.addItemPedido(request.getNumeroPedido(), request.getItem(), request.getQuantidade());
    if (Objects.isNull(itemPedido)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(itemPedido);
  }


}
