package br.com.fiap.postech.fastfood.controller.metodopagamento;

import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(info = @Info(title = "Metodo Pagamento", description = "Metodo Pagamento", version = "1.00"))
@Tag(name = "Metodo Pagamento", description = "Metodo Pagamento")
public interface MetodoPagamentoControllerSwagger {

    @Operation(
            summary = "Create Metodo Pagamento",
            description = "Create Metodo Pagamento",
            tags = {"Metodo Pagamento"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Metodo Pagamento created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Metodo Pagamento already exists")})
    ResponseEntity<Object> createMetodoPagamento(@RequestBody MetodoPagamentoRequest request);

    @Operation(
            summary = "Get all Metodo Pagamento",
            description = "Get all Metodo Pagamento",
            tags = {"Metodo Pagamento"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Metodo Pagamento found"),
            @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
    ResponseEntity<Object> getAllMetodoPagamento(@RequestBody Cliente cliente);

    @Operation(
            summary = "Get Metodo Pagamento by id",
            description = "Get Metodo Pagamento by id",
            tags = {"Metodo Pagamento"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Metodo Pagamento found"),
            @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
    @GetMapping(value = "/metodo-pagamentos/{id}")
    ResponseEntity<Object> getMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf);

    @Operation(
            summary = "Delete Metodo Pagamento by id",
            description = "Delete Metodo Pagamento by id",
            tags = {"Metodo Pagamento"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Metodo Pagamento deleted"),
            @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
    ResponseEntity<Object> deleteMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf);

}
