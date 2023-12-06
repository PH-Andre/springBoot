package br.guilherme.apipointsofinterest.DTOs;

import java.util.Date;

public record ErrorDTO(int code, String message, Date timestamp) {
}
