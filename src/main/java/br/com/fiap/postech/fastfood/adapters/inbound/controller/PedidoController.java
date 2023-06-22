package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.ItemPedido;
import br.com.fiap.postech.fastfood.core.domain.Pedido;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    @GetMapping("/pedidos")
    public ResponseEntity<Object> getAllPedidos() {
        List<Pedido> pedidos = pedidoServicePort.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{numeroPedido}")
    public ResponseEntity<Object> getPedidoByNumero(@PathVariable(value = "numeroPedido") String numeroPedido) {
        Pedido pedido = pedidoServicePort.findByNumeroPedido(numeroPedido);
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Object> createPedido(@RequestBody Pedido pedido) {
        try {

            Pedido createdPedido = pedidoServicePort.createPedido(pedido);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


    @PutMapping("/pedidos/{numeroPedido}")
    public ResponseEntity<Object> updateStatusPedido(@PathVariable(value = "numeroPedido") String numeroPedido, @RequestBody Pedido pedido) {
        try {

            Pedido updatedPedido = pedidoServicePort.updateStatusPedido(pedido);

            return ResponseEntity.status(HttpStatus.OK).body(updatedPedido);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
