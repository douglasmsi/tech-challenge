package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.domain.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.core.ports.item.ItemServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemController {

    private final ItemServicePort itemServicePort;

    @GetMapping("/items")
    ResponseEntity<Object> getAllItems(@RequestParam(name = "categoria", required = false) CategoriaItem categoria) {
        List<Item> items = null;
        if(Objects.nonNull(categoria)){
            items = itemServicePort.findAllByCategoria(categoria);
        } else {
            items = itemServicePort.findAll();
        }

        return ResponseEntity.ok(items);
    }

    @PostMapping("/items")
    ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemServicePort.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/items/{id}")
    ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) Long id) {
        Item item = itemServicePort.findById(id);
        if (Objects.nonNull(item)) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/items/{id}")
    ResponseEntity<Item> atualizarItem(@PathVariable(name = "id") Long id,@RequestBody Item item) {
        Item updatedItem = itemServicePort.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    ResponseEntity<Item> deletarItem(@PathVariable(name = "id") Long id) {
        itemServicePort.deletarItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
