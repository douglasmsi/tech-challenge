package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@RestController("itempedidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemPedidoController {

  private final ItemPedidoServicePort itemPedidoServicePort;

  @GetMapping(value = "/itempedidos", produces = "application/json")
  ResponseEntity<Object> getAllItemPedidos() {
    var itemPedidos = itemPedidoServicePort.findAll();
    return ResponseEntity.ok(itemPedidos);
  }

  @PostMapping(value = "/itempedidos")
  ResponseEntity<Object> addItemPedido(@RequestBody final ItemPedidoRequest request) {
    log.info("numeroPedido: {}", request.getNumeroPedido());
    var itemPedido = itemPedidoServicePort.addItemPedido(request.getNumeroPedido(), request.getItem(), request.getQuantidade());
    return isNull(itemPedido) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(itemPedido);
  }

}
