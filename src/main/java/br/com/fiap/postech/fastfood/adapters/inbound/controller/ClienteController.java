package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.ports.cliente.ClienteServicePort;
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
    public List<Cliente> getAllClientes(){
        return clienteServicePort.findAll();
    }

    @GetMapping("/clientes/{cpf}")
    public Cliente getClienteByCpf(@PathVariable(value = "cpf") String cpf){
        return clienteServicePort.findByCpf(cpf);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServicePort.save(cliente));
    }
}
