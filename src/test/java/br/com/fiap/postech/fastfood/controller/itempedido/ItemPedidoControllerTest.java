package br.com.fiap.postech.fastfood.controller.itempedido;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.ItemPedidoRequest;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.mock.item.ItemMock;
import br.com.fiap.postech.fastfood.mock.item_pedido.ItemPedidoMock;
import br.com.fiap.postech.fastfood.usecases.itempedido.AdicionarItemPedidoUseCase;
import br.com.fiap.postech.fastfood.usecases.itempedido.BuscarItemPedidoUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ExtendWith(MockitoExtension.class)
class ItemPedidoControllerTest {

    @Mock
    private AdicionarItemPedidoUseCase adicionarItemPedidoUseCase;

    @Mock
    private BuscarItemPedidoUseCase buscarItemPedidoUseCase;

    @InjectMocks
    private ItemPedidoController itemPedidoController;

    @Test
    void whenAddItemPedido_shouldReturnSuccess() throws Exception {
        final var itemPedido = ItemPedidoMock.create();
        final var itemPedidoRequest = ItemPedidoRequest.builder().item(ItemMock.create()).quantidade(10).build();
        final var content = new ObjectMapper().writeValueAsString(itemPedidoRequest);
        final var expectedJson = (new ObjectMapper()).writeValueAsString(itemPedido);

        when(adicionarItemPedidoUseCase.addItemPedido(anyString(), any(Item.class), anyInt()))
                .thenReturn(itemPedido);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pedidos/itempedido/{numeroPedido}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(itemPedidoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenAddItemPedido_shouldReturnBadRequest() throws Exception {
        final var errosResponse = new ErrorResponse("Falha ao adicionar item ao pedido");
        final var itemPedidoRequest = ItemPedidoRequest.builder().item(ItemMock.create()).quantidade(10).build();
        final var content = new ObjectMapper().writeValueAsString(itemPedidoRequest);
        final var expectedJson = (new ObjectMapper()).writeValueAsString(errosResponse);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pedidos/itempedido/{numeroPedido}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(itemPedidoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenGetAllItemPedidos_shouldReturnNotFound() throws Exception {
        final var errosResponse = new ErrorResponse("Itens não encontrados");
        final var expectedJson = (new ObjectMapper()).writeValueAsString(errosResponse);

        when(buscarItemPedidoUseCase.findByNumeroPedido(anyString())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pedidos/itempedido/{numeroPedido}",
                                                                                  "Numero Pedido");

        MockMvcBuilders.standaloneSetup(itemPedidoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenGetAllItemPedidos_shouldReturnPedidoNotFound() throws Exception {
        final var errosResponse = new ErrorResponse("Pedido não encontrado");
        final var expectedJson = (new ObjectMapper()).writeValueAsString(errosResponse);

        when(buscarItemPedidoUseCase.findByNumeroPedido(anyString())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pedidos/itempedido/{numeroPedido}",
                                                                                  "Numero Pedido");

        MockMvcBuilders.standaloneSetup(itemPedidoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenGetAllItemPedidos_shouldReturnOk() throws Exception {
        final var expectedResponse = """
                [{"item":{"id":null,"nome":"X-Burguer","descricao":"Muito bom","valor":10,"categoria":"LANCHE"},"quantidade":1,"valor":10,"observacao":"Observacao"}]""";

        when(buscarItemPedidoUseCase.findByNumeroPedido(anyString())).thenReturn(List.of(ItemPedidoMock.create()));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pedidos/itempedido/{numeroPedido}",
                                                                                  "Numero Pedido");
        MockMvcBuilders.standaloneSetup(itemPedidoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                                   .string(expectedResponse));
    }

}
