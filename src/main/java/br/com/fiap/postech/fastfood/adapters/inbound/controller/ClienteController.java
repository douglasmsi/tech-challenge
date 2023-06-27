package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClienteServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@OpenAPIDefinition(info = @Info(title = "Cliente", description = "Cliente", version = "1.00"))
@Tag(name = "Cliente", description = "Cliente")
@RequiredArgsConstructor
@RestController("clientes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    @Operation(
        summary = "All Clientes",
        description = "Returns a list of clientes"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})
    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllClientes(){
        var clientes = clienteServicePort.findAll();
        if (clientes.isEmpty()) {
            var errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(clientes);
    }

    @Operation(
        summary = "Cliente by CPF",
        description = "Returns a cliente by CPF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })})
    @GetMapping(value = "/clientes/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienteByCpf(@PathVariable(value = "cpf") final String cpf) {
        var cliente = clienteServicePort.findByCpf(cpf);
        if (isNull(cliente)) {
            var errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(cliente);
    }

    @Operation(
        summary = "Create Cliente",
        description = "Create a cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) })})
    @PostMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCliente(@RequestBody final Cliente cliente) {
        try {
            var createdCliente = clienteServicePort.save(cliente);
            return ResponseEntity.ok(createdCliente);
        } catch (DataIntegrityViolationException ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
