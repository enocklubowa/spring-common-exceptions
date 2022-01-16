package com.enocklubowa.springcommonexceptions.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message){
        super(message);
    }

    public AlreadyExistsException(Class<?> entity, Long id){
        super(String.format("%s identified with %d already exists", entity.getSimpleName(), id));
    }

    public AlreadyExistsException(Class<?> entity, String id){
        super(String.format("%s identified with %s already exists", entity.getSimpleName(), id));
    }
}
