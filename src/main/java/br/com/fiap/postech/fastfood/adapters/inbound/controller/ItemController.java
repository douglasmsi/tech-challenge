package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.core.domain.Item;
import br.com.fiap.postech.fastfood.core.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.core.ports.item.ItemServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemController {

    private final ItemServicePort itemServicePort;

    @GetMapping("/items")
    ResponseEntity<Object> getAllItems(@RequestParam(name = "categoria", required = false) final CategoriaItem categoria) {
        List<Item> items = null;
        if (nonNull(categoria)) {
            items = itemServicePort.findAllByCategoria(categoria);
        } else {
            items = itemServicePort.findAll();
        }

        return ResponseEntity.ok(items);
    }

    @PostMapping("/items")
    ResponseEntity<Item> createItem(@RequestBody final Item item) {
        var createdItem = itemServicePort.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/items/{id}")
    ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) final Long id) {
        var item = itemServicePort.findById(id);
        return nonNull(item) ? ResponseEntity.ok(item) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/items/{id}")
    ResponseEntity<Item> atualizarItem(@PathVariable(name = "id") final Long id, @RequestBody Item item) {
        var updatedItem = itemServicePort.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    ResponseEntity<Item> deletarItem(@PathVariable(name = "id") final Long id) {
        itemServicePort.deletarItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
