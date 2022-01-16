package com.enocklubowa.springcommonexceptions.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(Class<?> entity, long id){
        super(String.format("%s identified with %d not found", entity.getSimpleName(), id));
    }

    public NotFoundException(Class<?> entity, String id){
        super(String.format("%s identified with %s not found", entity.getSimpleName(), id));
    }
}
