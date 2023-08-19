package br.com.fiap.postech.fastfood.controller.pedido;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.UpdatePedidoRequest;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.domain.pedido.Pedido;
import br.com.fiap.postech.fastfood.usecases.pedido.AtualizarPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.pedido.BuscarPedidoParaEntregaUseCase;
import br.com.fiap.postech.fastfood.usecases.pedido.BuscarPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.pedido.CriarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PedidoController implements PedidoControllerSwagger {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final BuscarPedidoParaEntregaUseCase buscarPedidoParaEntregaUseCase;
    private final AtualizarPedidoUseCase atualizarPedidoUseCase;

    @GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPedidos() {
        List<Pedido> pedidos = buscarPedidoUseCase.findAll();
        if (pedidos.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping(value = "/pedidos-para-entrega", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPedidosParaEntrega() {
        List<Pedido> pedidos = buscarPedidoParaEntregaUseCase.findAllPedidosParaEntrega();
        if (pedidos.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping(value = "/pedidos/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPedidoByNumero(@PathVariable(value = "numeroPedido") String numeroPedido) {
        Pedido pedido = buscarPedidoUseCase.findByNumeroPedido(numeroPedido);
        if (pedido == null) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPedido(@RequestBody Cliente request) {
        try {
            // Verifique se o CPF foi fornecido
            if (request.getCpf() == null || request.getCpf().isEmpty()) {
                ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_WITHOUT_CPF_REQUEST.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            Pedido createdPedido = criarPedidoUseCase.createPedido(request);

            if (createdPedido == null) {
                ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_CREATION_FAILED.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_CREATION_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping(value = "/pedidos/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStatusPedido(@PathVariable(value = "numeroPedido") String numeroPedido, @RequestBody UpdatePedidoRequest request) {
        try {
            Pedido pedido = buscarPedidoUseCase.findByNumeroPedido(numeroPedido);
            if (pedido == null) {
                ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }

            // Chama o serviço para atualizar o status do pedido
            Pedido updatedPedido = atualizarPedidoUseCase.updateStatusPedido(request);

            return ResponseEntity.status(HttpStatus.OK).body(updatedPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_UPDATE_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
