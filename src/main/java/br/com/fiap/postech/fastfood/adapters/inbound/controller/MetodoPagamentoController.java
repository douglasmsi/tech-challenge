package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.inbound.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.core.ports.pagamento.MetodoPagamentoServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = "Metodo Pagamento", description = "Metodo Pagamento", version = "1.00"))
@Tag(name = "Metodo Pagamento", description = "Metodo Pagamento")
@RequiredArgsConstructor
@RestController("metodo-pagamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MetodoPagamentoController {

  final MetodoPagamentoServicePort metodoPagamentoServicePort;

  @Operation(
          summary = "Create Metodo Pagamento",
          description = "Create Metodo Pagamento",
          tags = {"Metodo Pagamento"}
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Metodo Pagamento created"),
          @ApiResponse(responseCode = "400", description = "Invalid input"),
          @ApiResponse(responseCode = "409", description = "Metodo Pagamento already exists")})
  @PostMapping(value = "/metodo-pagamentos")
  public ResponseEntity<Object> createMetodoPagamento(@RequestBody MetodoPagamentoRequest request) {
    return ResponseEntity.ok(metodoPagamentoServicePort.createMetodoPagamento(request));
  }

  @Operation(
          summary = "Get all Metodo Pagamento",
          description = "Get all Metodo Pagamento",
          tags = {"Metodo Pagamento"}
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Metodo Pagamento found"),
          @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
  @GetMapping(value = "/metodo-pagamentos")
  public ResponseEntity<Object> getAllMetodoPagamento(@RequestBody String cpf) {
    return ResponseEntity.ok(metodoPagamentoServicePort.findAllByCPF(cpf));
  }

  @Operation(
          summary = "Get Metodo Pagamento by id",
          description = "Get Metodo Pagamento by id",
          tags = {"Metodo Pagamento"}
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Metodo Pagamento found"),
          @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
  @GetMapping(value = "/metodo-pagamentos/{id}")
  public ResponseEntity<Object> getMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf) {
    return ResponseEntity.ok(metodoPagamentoServicePort.findByIdAndCPF(id, cpf));
  }

  @Operation(
          summary = "Delete Metodo Pagamento by id",
          description = "Delete Metodo Pagamento by id",
          tags = {"Metodo Pagamento"}
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Metodo Pagamento deleted"),
          @ApiResponse(responseCode = "404", description = "Metodo Pagamento not found")})
  @DeleteMapping(value = "/metodo-pagamentos/{id}")
  public ResponseEntity<Object> deleteMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf) {
    return ResponseEntity.ok(metodoPagamentoServicePort.deleteByIdAndCPF(id, cpf));
  }

}
