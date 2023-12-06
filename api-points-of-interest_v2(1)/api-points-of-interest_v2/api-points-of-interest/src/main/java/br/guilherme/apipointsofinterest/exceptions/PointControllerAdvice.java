package br.guilherme.apipointsofinterest.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.guilherme.apipointsofinterest.DTOs.ErrorDTO;

import org.springframework.http.HttpStatus;
import java.util.Date;

@ControllerAdvice
public class PointControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PointNotFoundException.class)
    public ErrorDTO handlePointNotFoundException() {
        return new ErrorDTO(
            HttpStatus.NOT_FOUND.value(), 
            "Point not found", 
            new Date());
    }
}
