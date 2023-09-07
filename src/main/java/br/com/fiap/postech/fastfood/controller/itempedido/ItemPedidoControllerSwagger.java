package br.com.fiap.postech.fastfood.controller.itempedido;

import br.com.fiap.postech.fastfood.controller.dto.ItemPedidoRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(info = @Info(title = "Item do Pedido", description = "Itens do pedido", version = "1.00"))
@Tag(name = "ItemPedido", description = "Itens do Pedido")
public interface ItemPedidoControllerSwagger {

    @Operation(
            summary = "All ItemPedidos by NumeroPedido",
            description = "Returns a list of itemPedidos by NumeroPedido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a list of itemPedidos by NumeroPedido."),
                    @ApiResponse(responseCode = "404", description = "No itemPedidos found for the given NumeroPedido.")
            }
    )
    ResponseEntity<Object> getAllItemPedidos(@PathVariable(name = "numeroPedido") String numeroPedido);

    @Operation(
            summary = "Add ItemPedido to NumeroPedido",
            description = "Add an itemPedido to the given NumeroPedido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "ItemPedido added successfully."),
                    @ApiResponse(responseCode = "400", description = "Failed to add the ItemPedido.")
            }
    )
    ResponseEntity<Object> addItemPedido(@PathVariable(name = "numeroPedido") String numeroPedido,
                                         @RequestBody ItemPedidoRequest request);

}
