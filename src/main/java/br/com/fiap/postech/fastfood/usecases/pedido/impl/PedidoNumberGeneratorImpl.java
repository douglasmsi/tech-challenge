package br.com.fiap.postech.fastfood.usecases.pedido.impl;

import br.com.fiap.postech.fastfood.usecases.pedido.PedidoNumberGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PedidoNumberGeneratorImpl implements PedidoNumberGenerator {

  private static final String FIXED_PREFIX = "FF";
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyy");
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("mmss");

  @Override
  public String generateNumber() {
    String currentDate = LocalDateTime.now().format(DATE_FORMATTER);
    String currentTime = LocalDateTime.now().format(TIME_FORMATTER);
    return FIXED_PREFIX + currentDate + currentTime;
  }
}
