package br.com.fiap.postech.fastfood.controller.metodopagamento;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.usecases.pagamento.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.CriarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.usecases.pagamento.DeletarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController("metodo-pagamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MetodoPagamentoController implements MetodoPagamentoControllerSwagger {

  private final CriarMetodoPagamentoUseCase criarMetodoPagamentoUseCase;
  private final BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase;
  private final DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase;

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

  @GetMapping(value = "/metodo-pagamentos")
  public ResponseEntity<Object> getAllMetodoPagamento(@RequestBody Cliente cliente) {
    List<MetodoPagamento> metodoPagamentos = buscarMetodoPagamentoUseCase.findByCpf(cliente.getCpf());
    if (metodoPagamentos.isEmpty()) {
      ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(metodoPagamentos);
  }

  @GetMapping(value = "/metodo-pagamentos/{id}")
  public ResponseEntity<Object> getMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf) {
    return ResponseEntity.ok(buscarMetodoPagamentoUseCase.findByIdAndCPF(id, cpf));
  }

  @DeleteMapping(value = "/metodo-pagamentos/{id}")
  public ResponseEntity<Object> deleteMetodoPagamentoById(@PathVariable Long id, @RequestBody String cpf) {
    return ResponseEntity.ok(deletarMetodoPagamentoUseCase.deleteByIdAndCPF(id, cpf));
  }

}
