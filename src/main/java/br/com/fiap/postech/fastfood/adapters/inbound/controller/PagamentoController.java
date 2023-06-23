package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Pagamento;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.core.ports.pagamento.PagamentoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoServicePort pagamentoServicePort;

  @GetMapping("/pagamentos")
  public ResponseEntity<Object> getAllPagamentos() {
    var pagamentos = pagamentoServicePort.findAll();
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pagamentos);
  }

  @GetMapping("/pagamentos/{id}")
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") final Long id) {
    var pagamento = pagamentoServicePort.findById(id);
    return pagamento == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pagamento);
  }

  @PostMapping("/pagamentos")
  public ResponseEntity<Object> createPagamento(@RequestBody final Pagamento pagamento) {
    try {
      var createdPagamento = pagamentoServicePort.save(pagamento);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    } catch (DataIntegrityViolationException ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_PAYLOAD_INVALID.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

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

  @GetMapping("/pagamentos/status/{status}")
  public ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") final PagamentoStatus status) {
    var pagamentos = pagamentoServicePort.findAllByStatus(status);
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pagamentos);
  }

}
