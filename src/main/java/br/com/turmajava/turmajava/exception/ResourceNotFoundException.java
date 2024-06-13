package br.com.turmajava.turmajava.exception;


import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    //construtor
    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}



