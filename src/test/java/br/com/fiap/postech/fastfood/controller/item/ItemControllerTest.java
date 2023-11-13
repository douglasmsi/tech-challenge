package br.com.fiap.postech.fastfood.controller.item;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.mock.item.ItemMock;
import br.com.fiap.postech.fastfood.usecases.item.AtualizarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.BuscarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.CriarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.DeletarItemUseCase;
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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private AtualizarItemUseCase atualizarItemUseCase;

    @Mock
    private BuscarItemUseCase buscarItemUseCase;

    @Mock
    private CriarItemUseCase criarItemUseCase;

    @Mock
    private DeletarItemUseCase deletarItemUseCase;

    @Test
    void whenCreateItem_shouldReturnSuccess() throws Exception {
        final var item = ItemMock.create();
        final var itemRequest = ItemMock.createItemRequest();
        when(criarItemUseCase.save(any(Item.class))).thenReturn(item);

        final var content = new ObjectMapper().writeValueAsString(itemRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        final var expectedJson = (new ObjectMapper()).writeValueAsString(item);

        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void whenCreateItem_shouldThrowExceptionItemInvalido() throws Exception {
        final var itemRequest = ItemMock.createItemRequest();
        final var expectedError = new ErrorResponse("Item Inválido");
        when(criarItemUseCase.save(any(Item.class))).thenThrow(DataIntegrityViolationException.class);

        final var content = new ObjectMapper().writeValueAsString(itemRequest);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        final var expectedJsonError = (new ObjectMapper()).writeValueAsString(expectedError);
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE));
        //.andExpect(MockMvcResultMatchers.content().json(expectedJsonError));
    }

    @Test
    void whenCreateItem_shouldThrowExceptionFalhaAoCriarItem() throws Exception {
        final var itemRequest = ItemMock.createItemRequest();
        final var expectedError = new ErrorResponse("Falha ao criar item");
        when(criarItemUseCase.save(any(Item.class))).thenThrow(IllegalArgumentException.class);

        final var content = new ObjectMapper().writeValueAsString(itemRequest);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        final var expectedJsonError = (new ObjectMapper()).writeValueAsString(expectedError);
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonError));
    }

    @Test
    void whenDeleteItem_shouldReturnSuccess() throws Exception {
        doNothing().when(deletarItemUseCase).deletarItem(any(Long.class));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/items/{id}", 1L);
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void whenDeleteItem_shouldThrowException() throws Exception {
        final var expectedError = """
                {"message":"Falha ao deletar item"}""";

        doThrow(new DataIntegrityViolationException("Msg")).when(deletarItemUseCase).deletarItem(any(Long.class));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/items/{id}", 1L);

        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().string(expectedError));
    }

    @Test
    void whenUpdateItem_shouldThrowException() throws Exception {
        final var expectedError = """
                {"message":"Falha ao atualizar item"}""";
        when(atualizarItemUseCase.save(any(Item.class))).thenThrow(new DataIntegrityViolationException("Msg"));

        String content = (new ObjectMapper()).writeValueAsString(ItemMock.create());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/items/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().string(expectedError));
    }

    @Test
    void whenGetAllItem_shouldReturnEmptyList() throws Exception {
        when(buscarItemUseCase.findAll()).thenReturn(Collections.emptyList());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items");
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void whenGetAllItem_shouldReturnSuccess() throws Exception {
        final var item = ItemMock.create();
        List<Item> itens = List.of(item);

        when(buscarItemUseCase.findAll()).thenReturn(itens);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items");
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(itens.size())))
                .andExpect(jsonPath("$.[0].nome").value("X-Burguer"));
    }

    @Test
    void whenGetItemById_shouldReturnSuccess() throws Exception {
        final var item = ItemMock.create();
        final var content = (new ObjectMapper()).writeValueAsString(item);

        when(buscarItemUseCase.findById(any(Long.class))).thenReturn(item);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items/{id}", 1L);
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content()
                                   .json(content));
    }

    @Test
    void whenGetItemById_shouldReturnNotFound() throws Exception {
        when(buscarItemUseCase.findById(any(Long.class))).thenReturn(null);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items/{id}", 1L);
        MockMvcBuilders.standaloneSetup(itemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_VALUE));
    }
}
