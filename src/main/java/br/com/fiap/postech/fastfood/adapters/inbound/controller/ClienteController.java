package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClienteServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Cliente", description = "Cliente", version = "1.00"))
@Tag(name = "Cliente", description = "Cliente")
@RequiredArgsConstructor
@RestController("clientes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    final ClienteServicePort clienteServicePort;

    @Operation(
        summary = "All Clientes",
        description = "Returns a list of clientes",
        responses = {@ApiResponse(responseCode = "200", description = "Get a list of clientes.")})
    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllClientes() {
        List<Cliente> clientes = clienteServicePort.findAll();
        if (clientes.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(clientes);
    }

    @Operation(
        summary = "Cliente by CPF",
        description = "Returns a cliente by CPF",
        responses = {@ApiResponse(responseCode = "200", description = "Get a cliente by CPF.")})
    @GetMapping(value = "/clientes/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienteByCpf(@PathVariable(value = "cpf") String cpf) {
        Cliente cliente = clienteServicePort.findByCpf(cpf);
        if (cliente == null) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(cliente);
    }

    @Operation(
        summary = "Create Cliente",
        description = "Create a cliente",
        responses = {@ApiResponse(responseCode = "200", description = "Create a cliente.")})
    @PostMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente createdCliente = clienteServicePort.save(cliente);
            return ResponseEntity.ok(createdCliente);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
