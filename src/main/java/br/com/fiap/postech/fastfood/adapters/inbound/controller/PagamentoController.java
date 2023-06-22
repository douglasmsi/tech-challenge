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

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController {

  private final PagamentoServicePort pagamentoServicePort;

  @GetMapping("/pagamentos")
  public ResponseEntity<Object> getAllPagamentos() {
    List<Pagamento> pagamentos = pagamentoServicePort.findAll();
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }

  @GetMapping("/pagamentos/{id}")
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") Long id) {
    Pagamento pagamento = pagamentoServicePort.findById(id);
    if (pagamento == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamento);
  }

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

  @GetMapping("/pagamentos/status/{status}")
  public ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") PagamentoStatus status) {
    List<Pagamento> pagamentos = pagamentoServicePort.findAllByStatus(status);
    if (pagamentos.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(pagamentos);
  }
}
