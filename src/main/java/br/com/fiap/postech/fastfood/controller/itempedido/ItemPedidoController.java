package br.com.fiap.postech.fastfood.controller.itempedido;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.domain.itempedido.ItemPedido;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.usecases.itempedido.AdicionarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.AtualizarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.BuscarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.DeletarItemPedidoUseCase;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = "Item do Pedido", description = "Itens do pedido", version = "1.00"))
@Tag(name = "ItemPedido", description = "Itens do Pedido")
@RequiredArgsConstructor
@RestController("itempedidos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemPedidoController {

  private final AdicionarItemPedidoUseCase adicionarItemPedidoUseCase;
  private final AtualizarItemPedidoUseCase atualizarItemPedidoUseCase;
  private final DeletarItemPedidoUseCase deletarItemPedidoUseCase;
  private final BuscarItemPedidoUseCase buscarItemPedidoUseCase;

  @Operation(
      summary = "All ItemPedidos by NumeroPedido",
      description = "Returns a list of itemPedidos by NumeroPedido",
      responses = {
          @ApiResponse(responseCode = "200", description = "Get a list of itemPedidos by NumeroPedido."),
          @ApiResponse(responseCode = "404", description = "No itemPedidos found for the given NumeroPedido.")
      }
  )
  @GetMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> getAllItemPedidos(@PathVariable(name = "numeroPedido") String numeroPedido) {
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

  @Operation(
      summary = "Add ItemPedido to NumeroPedido",
      description = "Add an itemPedido to the given NumeroPedido",
      responses = {
          @ApiResponse(responseCode = "200", description = "ItemPedido added successfully."),
          @ApiResponse(responseCode = "400", description = "Failed to add the ItemPedido.")
      }
  )
  @PostMapping(value = "/pedidos/itempedido/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> addItemPedido(@PathVariable(name = "numeroPedido") String numeroPedido, @RequestBody ItemPedidoRequest request) {

    ItemPedido itemPedido = adicionarItemPedidoUseCase.addItemPedido(numeroPedido, request.getItem(), request.getQuantidade());
    if (Objects.isNull(itemPedido)) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_PEDIDO_ADD_FAILED.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    return ResponseEntity.ok(itemPedido);
  }


}
