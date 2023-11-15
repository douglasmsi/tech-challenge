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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

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
    void whenCreateCliente_shouldReturnSuccess() throws Exception {
        final var cliente = ClienteMock.create();

        when(criarClienteUseCase.save(any(Cliente.class))).thenReturn(cliente);

        final var content = new ObjectMapper().writeValueAsString(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        final var expectedJson = (new ObjectMapper()).writeValueAsString(cliente);

        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void whenCreateCliente_shouldReturnConflictCpf() throws Exception {
        final var cliente = ClienteMock.create();
        final var expectedMessageError = """
                {"message":"CPF já cadastrado"}
                """;

        when(criarClienteUseCase.save(any(Cliente.class))).thenThrow(new DataIntegrityViolationException("Msg"));

        final var content = (new ObjectMapper()).writeValueAsString(cliente);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedMessageError));
    }

    @Test
    void whenGetAllClientes_shouldReturnNotFound() throws Exception {
        final var expectedMessageError = """
                {"message":"Cliente não encontrado"}
                """;

        when(buscarClienteUseCase.findAll()).thenReturn(Collections.emptyList());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedMessageError));
    }

    @Test
    void whenGetAllClientes_shouldReturnOk() throws Exception {
        final var clientes = List.of(ClienteMock.create());

        when(buscarClienteUseCase.findAll()).thenReturn(clientes);

        final var expectedJson = (new ObjectMapper()).writeValueAsString(clientes);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenGetClienteByCpf_shouldReturnOk() throws Exception {
        final var cliente = ClienteMock.create();
        when(buscarClienteUseCase.findByCpf(any(String.class)))
                .thenReturn(cliente);

        final var expectedJson = (new ObjectMapper()).writeValueAsString(cliente);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/{cpf}", "Cpf");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenGetClienteByCpf_shouldReturnNotFound() throws Exception {
        final var expectedMessageError = """
                {"message":"CPF não encontrado"}
                """;

        when(buscarClienteUseCase.findByCpf(any(String.class))).thenReturn(null);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/{cpf}", "Cpf");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedMessageError));
    }

    @Test
    void whenGetClienteByCpf_shouldReturnCliente() throws Exception {
        final var clientes = List.of(ClienteMock.create());
        final var expectedJson = (new ObjectMapper()).writeValueAsString(clientes);

        when(buscarClienteUseCase.findAll()).thenReturn(clientes);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/{cpf}",
                                                                                  "", "Uri " + "Variables");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
}
