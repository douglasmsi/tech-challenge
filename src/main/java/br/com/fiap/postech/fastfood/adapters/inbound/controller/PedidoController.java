package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    @GetMapping("/pedidos")
    public ResponseEntity<Object> getAllPedidos() {
        var pedidos = pedidoServicePort.findAll();
        return pedidos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{numeroPedido}")
    public ResponseEntity<Object> getPedidoByNumero(@PathVariable(value = "numeroPedido") final String numeroPedido) {
        var pedido = pedidoServicePort.findByNumeroPedido(numeroPedido);
        return pedido == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(pedido);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Object> createPedido(@RequestBody final Pedido pedido) {
        try {
            var createdPedido = pedidoServicePort.createPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
        } catch (DataIntegrityViolationException ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/pedidos/{numeroPedido}")
    public ResponseEntity<Object> updateStatusPedido(@PathVariable(value = "numeroPedido") final String numeroPedido, @RequestBody final Pedido pedido) {
        try {
            var updatedPedido = pedidoServicePort.updateStatusPedido(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPedido);
        } catch (DataIntegrityViolationException ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
