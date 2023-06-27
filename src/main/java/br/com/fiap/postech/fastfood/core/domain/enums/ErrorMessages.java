package br.com.fiap.postech.fastfood.core.domain.enums;

public enum ErrorMessages {
  CLIENTE_NOT_FOUND("Cliente não encontrado"),
  CLIENTE_ALREADY_EXISTS("Cliente já cadastrado"),
  CLIENTE_CPF_ALREADY_EXISTS("CPF já cadastrado"),
  CLIENTE_CPF_NOT_FOUND("CPF não encontrado"),

  PEDIDO_NOT_FOUND("Pedido não encontrado"),
  PEDIDO_ALREADY_EXISTS("Pedido já cadastrado"),
  PEDIDO_STATUS_NOT_FOUND("Status não encontrado"),
  PEDIDO_STATUS_INVALID("Status inválido"),
  PEDIDO_STATUS_INVALID_TRANSITION("Transição de status inválida"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_CANCEL("Transição de status inválida para cancelamento"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_CONFIRM("Transição de status inválida para confirmação"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_DELIVER("Transição de status inválida para entrega"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_FINISH("Transição de status inválida para finalização"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION("Transição de status inválida para preparação"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_CANCEL("Transição de status inválida para preparação para cancelamento"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_CONFIRM("Transição de status inválida para preparação para confirmação"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_DELIVER("Transição de status inválida para preparação para entrega"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_FINISH("Transição de status inválida para preparação para finalização"),
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_PREPARATION("Transição de status inválida para preparação para preparação"),
  PAGAMENTO_ALREADY_EXISTS("Pagamento já cadastrado"),
  PAGAMENTO_NOT_FOUND("Pagamento não encontrado"),
  PAGAMENTO_STATUS_NOT_FOUND("Status não encontrado"),
  PAGAMENTO_STATUS_INVALID("Status inválido"),
  PAGAMENTO_PAYLOAD_INVALID("Payload inválido"),
  ITEM_CREATION_FAILED("Falha ao criar item"),
  ITEM_NOT_FOUND( "Item não encontrado"),
  ITEM_UPDATE_FAILED( "Falha ao atualizar item"),
  ITEM_DELETION_FAILED( "Falha ao deletar item"),
  ITEM_PEDIDOS_NOT_FOUND("Item não encontrado"),
  ITEM_PEDIDO_ADD_FAILED("Falha ao adicionar item ao pedido"),
  PEDIDO_CREATION_FAILED("Falha ao criar pedido"),
  PEDIDO_UPDATE_FAILED( "Falha ao atualizar pedido"),
  PEDIDO_WITHOUT_CPF_REQUEST("Pedido sem CPF Válido"),
  INVALID_ITEM_REQUEST("Item inválido"),
  METODO_PAGAMENTO_NOT_FOUND(  "Método de pagamento não encontrado"), PAGAMENTO_INVALID_STATUS( "Status inválido para pagamento"),
  PEDIDO_CANCELADO("Pedido cancelado"),
  PEDIDO_ENTREGUE("Pedido entregue");


  private final String message;

  ErrorMessages(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
