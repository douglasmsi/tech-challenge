package br.com.fiap.postech.fastfood.controller.cliente;

import br.com.fiap.postech.fastfood.domain.cliente.Cliente;
import br.com.fiap.postech.fastfood.mock.cliente.ClienteMock;
import br.com.fiap.postech.fastfood.usecases.cliente.BuscarClienteUseCase;
import br.com.fiap.postech.fastfood.usecases.cliente.CriarClienteUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private BuscarClienteUseCase buscarClienteUseCase;

    @Mock
    private CriarClienteUseCase criarClienteUseCase;

    @Test
    void testCreateCliente_success() throws Exception {
        final var cliente = ClienteMock.create();
        when(criarClienteUseCase.save(any(Cliente.class))).thenReturn(cliente);

        String content = new ObjectMapper().writeValueAsString(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        String expectedJson = (new ObjectMapper()).writeValueAsString(cliente);

        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void testCreateCliente_conflictCpf() throws Exception {
        final var cliente = ClienteMock.create();
        when(criarClienteUseCase.save(any(Cliente.class))).thenThrow(new DataIntegrityViolationException("Msg"));

        String content = (new ObjectMapper()).writeValueAsString(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json("{\"message\":\"CPF já cadastrado\"}"));
    }

}
