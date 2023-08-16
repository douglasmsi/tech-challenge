package br.com.fiap.postech.fastfood.controller.pedido;

import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(info = @Info(title = "Pedido", description = "Pedidos", version = "1.00"))
@Tag(name = "Pedido", description = "Pedidos")
public interface PedidoControllerSwagger {

    @Operation(
            summary = "Get all Pedidos",
            description = "Returns a list of all Pedidos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a list of all Pedidos."),
                    @ApiResponse(responseCode = "404", description = "No Pedidos found.")
            }
    )
    ResponseEntity<Object> getAllPedidos();

    @Operation(
            summary = "Get Pedido by NumeroPedido",
            description = "Returns a Pedido by its NumeroPedido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a Pedido by its NumeroPedido."),
                    @ApiResponse(responseCode = "404", description = "No Pedido found for the given NumeroPedido.")
            }
    )
    ResponseEntity<Object> getPedidoByNumero(@PathVariable(value = "numeroPedido") String numeroPedido);

    @Operation(
            summary = "Create Pedido",
            description = "Create a new Pedido",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Pedido created successfully."),
                    @ApiResponse(responseCode = "400", description = "Failed to create the Pedido.")
            }
    )
    ResponseEntity<Object> createPedido(@RequestBody Cliente request);

    @Operation(
            summary = "Update Status Pedido",
            description = "Update the status of a Pedido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Status of Pedido updated successfully."),
                    @ApiResponse(responseCode = "400", description = "Failed to update the status of the Pedido.")
            }
    )
    ResponseEntity<Object> updateStatusPedido(@PathVariable(value = "numeroPedido") String numeroPedido,
                                              @RequestBody UpdatePedidoRequest request);

}
