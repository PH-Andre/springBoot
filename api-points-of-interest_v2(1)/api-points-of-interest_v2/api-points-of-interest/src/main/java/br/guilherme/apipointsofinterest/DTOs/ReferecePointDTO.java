package br.guilherme.apipointsofinterest.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReferecePointDTO {
    private int x;
    private int y;
    private int dMax;
}
