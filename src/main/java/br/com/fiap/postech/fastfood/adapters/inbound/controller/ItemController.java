package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.adapters.inbound.dto.ItemRequest;
import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.item.ItemServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@OpenAPIDefinition(info = @Info(title = "Item", description = "Itens", version = "1.00"))
@Tag(name = "Item", description = "Itens")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemController {

    private final ItemServicePort itemServicePort;

    @Operation(
        summary = "Get All Items",
        description = "Returns a list of all items",
        responses = {@ApiResponse(responseCode = "200", description = "Get a list of all items.")})
    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAllItems(@RequestParam(name = "categoria", required = false) CategoriaItem categoria) {
        List<Item> items = null;
        if(Objects.nonNull(categoria)){
            items = itemServicePort.findAllByCategoria(categoria);
        } else {
            items = itemServicePort.findAll();
        }

        return ResponseEntity.ok(items);
    }

    @Operation(
        summary = "Create Item",
        description = "Create a new item",
        responses = {
            @ApiResponse(responseCode = "201", description = "Create a new item."),
            @ApiResponse(responseCode = "400", description = "Failed to create the item.")
        }
    )
    @PostMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createItem(@RequestBody ItemRequest request) {
        try {

            Item item = Item.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .valor(request.getValor())
                .categoria(CategoriaItem.valueOf(request.getCategoria()))
                .build();

            Item createdItem = itemServicePort.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.INVALID_ITEM_REQUEST.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_CREATION_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @Operation(
        summary = "Get Item by ID",
        description = "Returns an item based on the ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Get an item by ID."),
            @ApiResponse(responseCode = "404", description = "Item not found.")
        })
    @GetMapping(value = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) Long id) {
        Item item = itemServicePort.findById(id);
        if (Objects.nonNull(item)) {
            return ResponseEntity.ok(item);
        }
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @Operation(
        summary = "Update Item",
        description = "Update an existing item",
        responses = {
            @ApiResponse(responseCode = "200", description = "Update an existing item."),
            @ApiResponse(responseCode = "404", description = "Item not found.")
        })
    @PutMapping(value = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> atualizarItem(@PathVariable(name = "id") Long id,@RequestBody Item item) {
        try {
            Item updatedItem = itemServicePort.save(item);
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_UPDATE_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @Operation(
        summary = "Delete Item",
        description = "Delete an existing item",
        responses = {@ApiResponse(responseCode = "200", description = "Delete an existing item.")})
    @DeleteMapping("/items/{id}")
    ResponseEntity<Object> deletarItem(@PathVariable(name = "id") Long id) {
        try {
            itemServicePort.deletarItem(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_DELETION_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
