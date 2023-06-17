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
  PEDIDO_STATUS_INVALID_TRANSITION_TO_PREPARATION_TO_PREPARATION("Transição de status inválida para preparação para preparação");

  private final String message;

  ErrorMessages(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}