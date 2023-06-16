package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.core.ports.pedido.PedidoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

}