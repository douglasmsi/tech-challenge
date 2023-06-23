package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.CriarPedidoRequest;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = "Pedido", description = "Pedidos", version = "1.00"))
@Tag(name = "Pedido", description = "Pedidos")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    @Operation(
        summary = "Get all Pedidos",
        description = "Returns a list of all Pedidos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Get a list of all Pedidos."),
            @ApiResponse(responseCode = "404", description = "No Pedidos found.")
        }
    )
    @GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPedidos() {
        List<Pedido> pedidos = pedidoServicePort.findAll();
        if (pedidos.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(pedidos);
    }

    @Operation(
        summary = "Get Pedido by NumeroPedido",
        description = "Returns a Pedido by its NumeroPedido",
        responses = {
            @ApiResponse(responseCode = "200", description = "Get a Pedido by its NumeroPedido."),
            @ApiResponse(responseCode = "404", description = "No Pedido found for the given NumeroPedido.")
        }
    )
    @GetMapping(value = "/pedidos/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPedidoByNumero(@PathVariable(value = "numeroPedido") String numeroPedido) {
        Pedido pedido = pedidoServicePort.findByNumeroPedido(numeroPedido);
        if (pedido == null) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(pedido);
    }

    @Operation(
        summary = "Create Pedido",
        description = "Create a new Pedido",
        responses = {
            @ApiResponse(responseCode = "201", description = "Pedido created successfully."),
            @ApiResponse(responseCode = "400", description = "Failed to create the Pedido.")
        }
    )
    @PostMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPedido(@RequestBody CriarPedidoRequest request) {
        try {
            // Verifique se o CPF foi fornecido
            if (request.getCpf() == null || request.getCpf().isEmpty()) {
                ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_WITHOUT_CPF_REQUEST.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            Pedido pedido = Pedido.builder()
                .statusPedido(PedidoStatus.valueOf(request.getStatusPedido()))
                .valorTotal(request.getValorTotal())
                .statusPagamento(PagamentoStatus.valueOf(request.getStatusPagamento()))
                .cpf(request.getCpf())
                .build();

            Pedido createdPedido = pedidoServicePort.createPedido(pedido);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_CREATION_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


    @Operation(
        summary = "Update Status Pedido",
        description = "Update the status of a Pedido",
        responses = {
            @ApiResponse(responseCode = "200", description = "Status of Pedido updated successfully."),
            @ApiResponse(responseCode = "400", description = "Failed to update the status of the Pedido.")
        }
    )
    @PutMapping(value = "/pedidos/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStatusPedido(@PathVariable(value = "numeroPedido") String numeroPedido, @RequestBody Pedido pedido) {
        try {
            Pedido updatedPedido = pedidoServicePort.updateStatusPedido(pedido);

            return ResponseEntity.status(HttpStatus.OK).body(updatedPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_UPDATE_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
