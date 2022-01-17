package com.enocklubowa.springcommonexceptions.exception;

/**
 * Exception that should be shown when an entity when an entity is not found in the database.
 */
public class NotFoundException extends RuntimeException{

    /**
     * Throw exception with just a message
     * @param message
     */
    public NotFoundException(String message){
        super(message);
    }

    /**
     * Throw exception with details about entity class and the identifier
     * @param entity
     * @param id
     */
    public NotFoundException(Class<?> entity, long id){
        super(String.format("%s identified with %d not found", entity.getSimpleName(), id));
    }

    /**
     * Throw exception with details about entity class and the identifier
     * @param entity
     * @param id
     */
    public NotFoundException(Class<?> entity, String id){
        super(String.format("%s identified with %s not found", entity.getSimpleName(), id));
    }
}
