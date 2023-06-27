package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.CriarCheckoutRequest;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoServicePort;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
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

import static java.util.Objects.isNull;

@RestController
@Tag(name = "Pagamento", description = "Pagamento")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoServicePort pagamentoServicePort;
  private final PedidoServicePort pedidoServicePort;

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
    var pagamentos = pagamentoServicePort.findAll();
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pagamentos);
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
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") final Long id) {
    var pagamento = pagamentoServicePort.findById(id);
    return isNull(pagamento) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                          ResponseEntity.ok(pagamento);
  }

  @Operation(
          summary = "Create Pagamento",
          description = "Create a Pagamento")
  @ApiResponses({
          @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pagamento.class), mediaType = "application/json") }),
          @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  })
  @PostMapping("/pedidos/checkout/{numeroPedido}")
  public ResponseEntity<Object> createPagamento(@PathVariable(name = "numeroPedido") String numeroPedido, @RequestBody CriarCheckoutRequest request) {
    try {
      var createdPagamento = pagamentoServicePort.save(pagamento);

      Pedido pedido = pedidoServicePort.findByNumeroPedido(numeroPedido);
      if (isNull(pedido)) {
        var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
      }

      //TO-DO: Executar pagamento externamente e com o retorno, atualizar o pagamento.

      Pagamento pagamento = Pagamento.builder()
          .pedido(pedido)
          .status(PagamentoStatus.APROVADO)
          .metodoPagamento(
              MetodoPagamento.builder()
                  .cvv(request.getCvv())
                  .dataExpiracao(request.getDataExpiracao())
                  .numeroCartao(request.getNumeroCartao())
                  .build()
          )
          .build();

      Pagamento createdPagamento = pagamentoServicePort.save(pagamento);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    } catch (DataIntegrityViolationException ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_PAYLOAD_INVALID.getMessage());
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
  public ResponseEntity<Object> updateStatusPagamento(@PathVariable(value = "id") final Long id, @RequestBody final Pagamento pagamento) {
    var existingPagamento = pagamentoServicePort.findById(id);
    if (isNull(existingPagamento)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    pagamento.setId(existingPagamento.getId()); // Mantém o ID original do pagamento
    var updatedPagamento = pagamentoServicePort.updateStatusPagamento(pagamento);
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
  public ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") final PagamentoStatus status) {
    var pagamentos = pagamentoServicePort.findAllByStatus(status);
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pagamentos);
  }

}
