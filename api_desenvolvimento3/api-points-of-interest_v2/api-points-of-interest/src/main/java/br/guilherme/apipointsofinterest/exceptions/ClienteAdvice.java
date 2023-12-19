package br.guilherme.apipointsofinterest.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.BindException;
import br.guilherme.apipointsofinterest.DTOs.ErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ClienteAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClienteBloqueadoException.class)
    public ErrorDTO handlePointNotFoundException() {
        Map<String, String> BloqueadoMsg = new HashMap<>();
        BloqueadoMsg.put("false", "Cliente Bloqueado por motivos desconhecidos");


        return new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(), 
            BloqueadoMsg, 
            new Date());
    }


    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleValidationException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return new ErrorDTO( HttpStatus.BAD_REQUEST.value(), errors, new Date()  );
    }


}