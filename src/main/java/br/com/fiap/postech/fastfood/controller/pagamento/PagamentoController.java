package br.com.fiap.postech.fastfood.controller.pagamento;

import br.com.fiap.postech.fastfood.controller.dto.CriarCheckoutRequest;
import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.usecases.pagamento.AtualizarStatusPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.BuscarPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.CriarPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pedido.BuscarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController implements PagamentoControllerSwagger {

  private final CriarPagamentoUseCase criarPagamentoUseCase;
  private final BuscarPagamentoUseCase buscarPagamentoUseCase;
  private final AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase;
  private final BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase;
  private final BuscarPedidoUseCase buscarPedidoUseCase;

  @GetMapping("/pagamentos")
  public ResponseEntity<Object> getAllPagamentos() {
    List<Pagamento> pagamentos = buscarPagamentoUseCase.findAll();
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }

  @GetMapping("/pagamentos/{id}")
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") Long id) {
    Pagamento pagamento = buscarPagamentoUseCase.findById(id);
    if (pagamento == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamento);
  }

  @PostMapping("/pedidos/checkout/{numeroPedido}")
  public ResponseEntity<Object> createPagamento(@PathVariable(name = "numeroPedido") String numeroPedido, @RequestBody CriarCheckoutRequest request) {
    try {
      Pedido pedido = buscarPedidoUseCase.findByNumeroPedido(numeroPedido);
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

      MetodoPagamento metodoPagamento = buscarMetodoPagamentoUseCase.findByIdAndCPF(request.getMetodoPagamentoId(), request.getCpf());
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

      Pagamento createdPagamento = criarPagamentoUseCase.save(pagamento);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    } catch (DataIntegrityViolationException ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_PAYLOAD_INVALID.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

  @PutMapping("/pagamentos/{id}")
  public ResponseEntity<Object> updateStatusPagamento(@PathVariable(value = "id") Long id, @RequestBody Pagamento pagamento) {
    Pagamento existingPagamento = buscarPagamentoUseCase.findById(id);
    if (existingPagamento == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    pagamento.setId(existingPagamento.getId()); // Mantém o ID original do pagamento
    Pagamento updatedPagamento = atualizarStatusPagamentoUseCase.updateStatusPagamento(pagamento);
    return ResponseEntity.ok(updatedPagamento);
  }

  @GetMapping("/pagamentos/status/{status}")
  public ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") PagamentoStatus status) {
    List<Pagamento> pagamentos = buscarPagamentoUseCase.findAllByStatus(status);
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }
}
