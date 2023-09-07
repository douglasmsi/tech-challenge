package br.com.fiap.postech.fastfood.controller.cliente;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.usecases.cliente.BuscarClienteUseCase;
import br.com.fiap.postech.fastfood.usecases.cliente.CriarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController("clientes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController implements ClienteControllerSwagger {

    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllClientes() {
        List<Cliente> clientes = buscarClienteUseCase.findAll();
        if (clientes.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/clientes/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienteByCpf(@PathVariable(value = "cpf") String cpf) {
        Cliente cliente = buscarClienteUseCase.findByCpf(cpf);
        if (cliente == null) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente createdCliente = criarClienteUseCase.save(cliente);
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
