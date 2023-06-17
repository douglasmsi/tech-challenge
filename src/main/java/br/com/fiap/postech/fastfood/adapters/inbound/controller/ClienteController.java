package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.persistence.entities.ClienteEntity;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClienteServicePort;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    final ClienteServicePort clienteServicePort;


    @GetMapping("/clientes")
    public ResponseEntity<Object> getAllClientes(){
        List<Cliente> clientes = clienteServicePort.findAll();
        if (clientes.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<Object> getClienteByCpf(@PathVariable(value = "cpf") String cpf) {
        Cliente cliente = clienteServicePort.findByCpf(cpf);
        if (cliente == null){
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(cliente);
    }


    @PostMapping("/clientes")
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente){
        try {
            Cliente createdCliente = clienteServicePort.save(cliente);
            return ResponseEntity.ok(createdCliente);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_ALREADY_EXISTS.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

