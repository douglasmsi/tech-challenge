package br.com.fiap.postech.fastfood.controller.metodopagamento;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.usecases.pagamento.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.CriarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.DeletarMetodoPagamentoUseCase;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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

  private final CriarMetodoPagamentoUseCase criarMetodoPagamentoUseCase;
  private final BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase;
  private final DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase;


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
    try {
      MetodoPagamento createdMetodoPagamento = criarMetodoPagamentoUseCase.createMetodoPagamento(request);
      if (createdMetodoPagamento == null) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(createdMetodoPagamento);
    } catch (DataIntegrityViolationException ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_CREATION_FAILED.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
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
  public ResponseEntity<Object> getAllMetodoPagamento(@RequestBody Cliente cliente) {
    List<MetodoPagamento> metodoPagamentos = buscarMetodoPagamentoUseCase.findByCpf(cliente.getCpf());
    if (metodoPagamentos.isEmpty()) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(metodoPagamentos);
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
    return ResponseEntity.ok(buscarMetodoPagamentoUseCase.findByIdAndCPF(id, cpf));
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
    return ResponseEntity.ok(deletarMetodoPagamentoUseCase.deleteByIdAndCPF(id, cpf));
  }

}
