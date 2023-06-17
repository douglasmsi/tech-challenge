package br.com.fiap.postech.fastfood.adapters.inbound.controller;

import br.com.fiap.postech.fastfood.adapters.dtos.ErrorResponse;
import br.com.fiap.postech.fastfood.core.domain.Cliente;
import br.com.fiap.postech.fastfood.core.domain.Item;
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
    ResponseEntity<Object> getAllItems(){
        List<Item> items = itemServicePort.findAll();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/items")
    ResponseEntity<Object> createItem(@RequestBody Item item){
            Item createdItem = itemServicePort.save(item);
            return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/items/{id}")
    ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) Long id){
        Item item = itemServicePort.findById(id);
        if(Objects.nonNull(item)){
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
