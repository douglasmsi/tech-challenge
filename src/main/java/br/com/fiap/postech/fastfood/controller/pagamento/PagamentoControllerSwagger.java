package br.com.fiap.postech.fastfood.controller.pagamento;

import br.com.fiap.postech.fastfood.controller.dto.CriarCheckoutRequest;
import br.com.fiap.postech.fastfood.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.domain.pagamento.Pagamento;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(info = @Info(title = "Pagamento", description = "Pagamento", version = "1.00"))
@Tag(name = "Pagamento", description = "Pagamento")
public interface PagamentoControllerSwagger {

    @Operation(
            summary = "Get all Pagamentos",
            description = "Returns a list of all Pagamentos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a list of all Pagamentos."),
                    @ApiResponse(responseCode = "404", description = "No Pagamentos found.")
            }
    )
    ResponseEntity<Object> getAllPagamentos();

    @Operation(
            summary = "Get Pagamento by id",
            description = "Returns a Pagamento by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a Pagamento by its id."),
                    @ApiResponse(responseCode = "404", description = "No Pagamento found for the given id.")
            }
    )
    ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Create Pagamento",
            description = "Create a Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Pagamento.class)
                    , mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    ResponseEntity<Object> createPagamento(@PathVariable(name = "numeroPedido") String numeroPedido,
                                           @RequestBody CriarCheckoutRequest request);

    @Operation(
            summary = "Update Status Pagamento",
            description = "Update the status of a Pagamento",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Status of Pagamento updated successfully."),
                    @ApiResponse(responseCode = "404", description = "Pagamento not found."),
                    @ApiResponse(responseCode = "400", description = "Failed to update the status of the Pagamento.")
            }
    )
    ResponseEntity<Object> updateStatusPagamento(@PathVariable(value = "id") Long id,
                                                 @RequestBody Pagamento pagamento);

    @Operation(
            summary = "Get Pagamento by status",
            description = "Returns a Pagamento by its status",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get a Pagamento by its status."),
                    @ApiResponse(responseCode = "404", description = "No Pagamento found for the given status.")
            }
    )
    ResponseEntity<Object> getPagamentosByStatus(@PathVariable(value = "status") PagamentoStatus status);

}
