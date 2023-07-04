package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.CriarCheckoutRequest;
import br.com.fiap.postech.fastfood.adapters.persistence.pagamento.MetodoPagamentoJpaRepository;
import br.com.fiap.postech.fastfood.core.domain.MetodoPagamento;
import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.MetodoPagamentoServicePort;
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

import java.util.List;

@RestController
@Tag(name = "Pagamento", description = "Pagamento")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoServicePort pagamentoServicePort;
  private final PedidoServicePort pedidoServicePort;
  private final MetodoPagamentoServicePort metodoPagamentoServicePort;

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
  @PostMapping("/pedidos/checkout/{numeroPedido}")
  public ResponseEntity<Object> createPagamento(@PathVariable(name = "numeroPedido") String numeroPedido, @RequestBody CriarCheckoutRequest request) {
    try {

      Pedido pedido = pedidoServicePort.findByNumeroPedido(numeroPedido);
      if (pedido == null) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
      }

      // Validar se o pedido já foi pago.
      if (pedido.getStatusPagamento() != PagamentoStatus.PENDENTE) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_INVALID_STATUS.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      //Validar se o pedido já foi cancelado.
      if (pedido.getStatusPedido() == PedidoStatus.CANCELADO) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_CANCELADO.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      // Validar se o pedido já foi entregue.
      if (pedido.getStatusPedido() == PedidoStatus.ENTREGA) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ENTREGUE.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      MetodoPagamento metodoPagamento = metodoPagamentoServicePort.findByIdAndCPF(request.getMetodoPagamentoId(), request.getCpf());
      if (metodoPagamento == null) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
      }

      //TO-DO: Executar pagamento externamente e com o retorno, atualizar o pagamento.

      Pagamento pagamento = Pagamento.builder()
              .pedido(pedido)
              .metodoPagamento(metodoPagamento)
              .status(PagamentoStatus.APROVADO)
              .build();

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
