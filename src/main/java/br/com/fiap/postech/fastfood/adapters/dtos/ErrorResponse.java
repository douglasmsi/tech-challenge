package br.com.fiap.postech.fastfood.adapters.dtos;

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
