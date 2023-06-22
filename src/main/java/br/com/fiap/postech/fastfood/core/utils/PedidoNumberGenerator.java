package br.com.fiap.postech.fastfood.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PedidoNumberGenerator {

  private static final String FIXED_PREFIX = "FF";
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyy");
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("mmss");

  public static String generateNumber() {
    String currentDate = LocalDateTime.now().format(DATE_FORMATTER);
    String currentTime = LocalDateTime.now().format(TIME_FORMATTER);
    return FIXED_PREFIX + currentDate + currentTime;
  }
}
