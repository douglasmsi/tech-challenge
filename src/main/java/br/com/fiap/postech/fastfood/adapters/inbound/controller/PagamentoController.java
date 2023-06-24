package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pagamento", description = "Pagamento")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoServicePort pagamentoServicePort;

  @Operation(
          summary = "Get all Pagamentos",
          description = "Returns a list of all Pagamentos",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Get a list of all Pagamentos."),
                  @ApiResponse(responseCode = "404", description = "No Pagamentos found.")
          }
  )
  @GetMapping("/pagamentos")
  public ResponseEntity<Object> getAllPagamentos() {
    List<Pagamento> pagamentos = pagamentoServicePort.findAll();
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }

  @Operation(
          summary = "Get Pagamento by id",
          description = "Returns a Pagamento by its id",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Get a Pagamento by its id."),
                  @ApiResponse(responseCode = "404", description = "No Pagamento found for the given id.")
          }
  )
  @GetMapping("/pagamentos/{id}")
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") Long id) {
    Pagamento pagamento = pagamentoServicePort.findById(id);
    if (pagamento == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamento);
  }

  @Operation(
          summary = "Create Pagamento",
          description = "Create a Pagamento")
  @ApiResponses({
          @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pagamento.class), mediaType = "application/json") }),
          @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @PostMapping("/pagamentos")
  public ResponseEntity<Object> createPagamento(@RequestBody Pagamento pagamento) {
    try {
      Pagamento createdPagamento = pagamentoServicePort.save(pagamento);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    } catch (DataIntegrityViolationException ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_PAYLOAD_INVALID.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

  }

  @Operation(
          summary = "Update Status Pagamento",
          description = "Update the status of a Pagamento",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Status of Pagamento updated successfully."),
                  @ApiResponse(responseCode = "404", description = "Pagamento not found."),
                  @ApiResponse(responseCode = "400", description = "Failed to update the status of the Pagamento.")
          }
  )
  @PutMapping("/pagamentos/{id}")
  public ResponseEntity<Object> updateStatusPagamento(@PathVariable(value = "id") Long id, @RequestBody Pagamento pagamento) {
    Pagamento existingPagamento = pagamentoServicePort.findById(id);
    if (existingPagamento == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    pagamento.setId(existingPagamento.getId()); // Mantém o ID original do pagamento
    Pagamento updatedPagamento = pagamentoServicePort.updateStatusPagamento(pagamento);
    return ResponseEntity.ok(updatedPagamento);
  }

  @Operation(
          summary = "Get Pagamento by status",
          description = "Returns a Pagamento by its status",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Get a Pagamento by its status."),
                  @ApiResponse(responseCode = "404", description = "No Pagamento found for the given status.")
          }
  )
  @GetMapping("/pagamentos/status/{status}")
  public ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") PagamentoStatus status) {
    List<Pagamento> pagamentos = pagamentoServicePort.findAllByStatus(status);
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }
}
