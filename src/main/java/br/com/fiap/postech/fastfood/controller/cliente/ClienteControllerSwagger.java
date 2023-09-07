package br.com.fiap.postech.fastfood.controller.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(info = @Info(title = "Cliente", description = "Cliente", version = "1.00"))
@Tag(name = "Cliente", description = "Cliente")
public interface ClienteControllerSwagger {

    @Operation(
            summary = "All Clientes",
            description = "Returns a list of clientes"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Cliente.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    ResponseEntity<Object> getAllClientes();

    @Operation(
            summary = "Cliente by CPF",
            description = "Returns a cliente by CPF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Cliente.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    ResponseEntity<Object> getClienteByCpf(@PathVariable(value = "cpf") String cpf);

    @Operation(
            summary = "Create Cliente",
            description = "Create a cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Cliente.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())})})
    ResponseEntity<Object> createCliente(@RequestBody Cliente cliente);

}
