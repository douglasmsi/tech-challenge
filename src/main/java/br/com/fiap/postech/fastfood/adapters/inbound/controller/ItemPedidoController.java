package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.itempedido.ItemPedidoServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@Slf4j
@OpenAPIDefinition(info = @Info(title = "Item do Pedido", description = "Itens do pedido", version = "1.00"))
@Tag(name = "ItemPedido", description = "Itens do Pedido")
@RequiredArgsConstructor
@RestController("itempedidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemPedidoController {

  private final ItemPedidoServicePort itemPedidoServicePort;

  @Operation(
          summary = "All ItemPedidos by NumeroPedido",
          description = "Returns a list of itemPedidos by NumeroPedido",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Get a list of itemPedidos by NumeroPedido."),
                  @ApiResponse(responseCode = "404", description = "No itemPedidos found for the given NumeroPedido.")
          }
  )
  @GetMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> getAllItemPedidos(@PathVariable(name = "numeroPedido") final String numeroPedido) {
    var itemPedidos = itemPedidoServicePort.findByNumeroPedido(numeroPedido);
    if (itemPedidos.isEmpty()) {
      var errorResponse = new ErrorResponse(ErrorMessages.ITEM_PEDIDOS_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(itemPedidos);
  }

  @Operation(
      summary = "Add ItemPedido to NumeroPedido",
      description = "Add an itemPedido to the given NumeroPedido",
      responses = {
          @ApiResponse(responseCode = "200", description = "ItemPedido added successfully."),
          @ApiResponse(responseCode = "400", description = "Failed to add the ItemPedido.")
      }
  )
  @PostMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> addItemPedido(@PathVariable(name = "numeroPedido") final String numeroPedido,
                                       @RequestBody final ItemPedidoRequest request) {
    ItemPedido itemPedido = itemPedidoServicePort.addItemPedido(numeroPedido, request.getItem(),
                                                                request.getQuantidade());
    if (isNull(itemPedido)) {
      var errorResponse = new ErrorResponse(ErrorMessages.ITEM_PEDIDO_ADD_FAILED.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    return ResponseEntity.ok(itemPedido);
  }

}
