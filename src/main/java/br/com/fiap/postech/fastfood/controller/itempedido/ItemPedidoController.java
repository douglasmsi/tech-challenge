package br.com.fiap.postech.fastfood.controller.itempedido;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.usecases.itempedido.AdicionarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.BuscarItemPedidoUseCase;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@OpenAPIDefinition(info = @Info(title = "Item do Pedido", description = "Itens do pedido", version = "1.00"))
@Tag(name = "ItemPedido", description = "Itens do Pedido")
@RequiredArgsConstructor
@RestController("itempedidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemPedidoController implements ItemPedidoControllerSwagger {

  private final AdicionarItemPedidoUseCase adicionarItemPedidoUseCase;
  private final BuscarItemPedidoUseCase buscarItemPedidoUseCase;

  @GetMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getAllItemPedidos(@PathVariable(name = "numeroPedido") String numeroPedido) {
    List<ItemPedido> itemPedidos = buscarItemPedidoUseCase.findByNumeroPedido(numeroPedido);

    if (Objects.isNull(itemPedidos)) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    if (itemPedidos.isEmpty()) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_PEDIDOS_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    return ResponseEntity.ok(itemPedidos);
  }

  @PostMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> addItemPedido(@PathVariable(name = "numeroPedido") String numeroPedido,
                                              @RequestBody ItemPedidoRequest request) {

    ItemPedido itemPedido = adicionarItemPedidoUseCase.addItemPedido(numeroPedido, request.getItem(), request.getQuantidade());
    if (Objects.isNull(itemPedido)) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_PEDIDO_ADD_FAILED.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    return ResponseEntity.ok(itemPedido);
  }

}
