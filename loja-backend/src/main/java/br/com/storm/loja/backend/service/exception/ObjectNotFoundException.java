package br.com.storm.loja.backend.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message){
        super(message);
    }

    public ObjectNotFoundException(Exception ex){
        super(ex);
    }

    public ObjectNotFoundException(String message, Exception ex){
        super(message, ex);
    }
}
