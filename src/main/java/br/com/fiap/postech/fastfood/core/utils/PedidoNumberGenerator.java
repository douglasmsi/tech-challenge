package br.com.fiap.postech.fastfood.core.utils;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class PedidoNumberGenerator {

  private static final String FIXED_PREFIX = "FF";
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyy");
  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("mmss");

  public static String generateNumber() {
    var currentDate = LocalDateTime.now().format(DATE_FORMATTER);
    var currentTime = LocalDateTime.now().format(TIME_FORMATTER);
    return FIXED_PREFIX + currentDate + currentTime;
  }

}
