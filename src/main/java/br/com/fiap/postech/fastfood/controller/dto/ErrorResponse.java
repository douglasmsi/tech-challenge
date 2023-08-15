package br.com.fiap.postech.fastfood.controller.dto;

public class ErrorResponse {
  private String message;

  public ErrorResponse(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
