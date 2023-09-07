package br.com.fiap.postech.fastfood.controller.item;

import br.com.fiap.postech.fastfood.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.controller.dto.ItemRequest;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.domain.item.Item;
import br.com.fiap.postech.fastfood.usecases.item.AtualizarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.BuscarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.CriarItemUseCase;
import br.com.fiap.postech.fastfood.usecases.item.DeletarItemUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemController implements ItemControllerSwagger {

    private final CriarItemUseCase criarItemUseCase;
    private final AtualizarItemUseCase atualizarItemUseCase;
    private final BuscarItemUseCase buscarItemUseCase;
    private final DeletarItemUseCase deletarItemUseCase;

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllItems(@RequestParam(name = "categoria", required = false) CategoriaItem categoria) {
        List<Item> items = null;
        if(Objects.nonNull(categoria)){
            items = buscarItemUseCase.findAllByCategoria(categoria);
        } else {
            items = buscarItemUseCase.findAll();
        }
        return ResponseEntity.ok(items);
    }

    @PostMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createItem(@RequestBody ItemRequest request) {
        try {

            Item item = Item.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .valor(request.getValor())
                .categoria(CategoriaItem.valueOf(request.getCategoria()))
                .build();

            Item createdItem = criarItemUseCase.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.INVALID_ITEM_REQUEST.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_CREATION_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping(value = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) Long id) {
        Item item = buscarItemUseCase.findById(id);
        if (Objects.nonNull(item)) {
            return ResponseEntity.ok(item);
        }
        ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @PutMapping(value = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizarItem(@PathVariable(name = "id") Long id,@RequestBody Item item) {
        try {
            Item updatedItem = atualizarItemUseCase.save(item);
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorMessages.ITEM_UPDATE_FAILED.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Object> deletarItem(@PathVariable(name = "id") Long id) {
        try {
            deletarItemUseCase.deletarItem(id);
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
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
