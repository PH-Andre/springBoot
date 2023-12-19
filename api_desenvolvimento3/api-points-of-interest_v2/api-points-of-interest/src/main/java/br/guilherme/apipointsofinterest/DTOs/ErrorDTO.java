package br.guilherme.apipointsofinterest.DTOs;

import java.util.Date;
import java.util.Map;

public record ErrorDTO(int code, Map<String, String> erros, Date timestamp) {
}
