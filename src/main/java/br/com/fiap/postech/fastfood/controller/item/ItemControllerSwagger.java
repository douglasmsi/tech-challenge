package br.com.fiap.postech.fastfood.controller.item;

import br.com.fiap.postech.fastfood.controller.dto.ItemRequest;
import br.com.fiap.postech.fastfood.domain.enums.CategoriaItem;
import br.com.fiap.postech.fastfood.domain.item.Item;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@OpenAPIDefinition(info = @Info(title = "Item", description = "Itens", version = "1.00"))
@Tag(name = "Item", description = "Itens")
public interface ItemControllerSwagger {

    @Operation(
            summary = "Get All Items",
            description = "Returns a list of all items",
            responses = {@ApiResponse(responseCode = "200", description = "Get a list of all items.")})
    ResponseEntity<Object> getAllItems(@RequestParam(name = "categoria", required = false) CategoriaItem categoria);

    @Operation(
            summary = "Create Item",
            description = "Create a new item",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Create a new item."),
                    @ApiResponse(responseCode = "400", description = "Failed to create the item.")
            }
    )
    ResponseEntity<Object> createItem(@RequestBody ItemRequest request);

    @Operation(
            summary = "Get Item by ID",
            description = "Returns an item based on the ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get an item by ID."),
                    @ApiResponse(responseCode = "404", description = "Item not found.")
            })
    ResponseEntity<Object> getItemById(@PathVariable(name = "id", required = true) Long id);

    @Operation(
            summary = "Update Item",
            description = "Update an existing item",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Update an existing item."),
                    @ApiResponse(responseCode = "404", description = "Item not found.")
            })
    ResponseEntity<Object> atualizarItem(@PathVariable(name = "id") Long id,@RequestBody Item item);

    @Operation(
            summary = "Delete Item",
            description = "Delete an existing item",
            responses = {@ApiResponse(responseCode = "200", description = "Delete an existing item.")})
    ResponseEntity<Object> deletarItem(@PathVariable(name = "id") Long id);

}
