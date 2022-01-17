package com.enocklubowa.springcommonexceptions.exception;

/**
 * Exception that should be shown when an entity already exists in the database.
 */
public class AlreadyExistsException extends RuntimeException {

    /**
     * Throw exception with just a message
     * @param message
     */
    public AlreadyExistsException(String message){
        super(message);
    }

    /**
     * Throw exception with details about the entity class and the identifier
     * @param entity
     * @param id
     */
    public AlreadyExistsException(Class<?> entity, Long id){
        super(String.format("%s identified with %d already exists", entity.getSimpleName(), id));
    }

    /**
     * Throw exception with details about the entity class and the identifier
     * @param entity
     * @param id
     */
    public AlreadyExistsException(Class<?> entity, String id){
        super(String.format("%s identified with %s already exists", entity.getSimpleName(), id));
    }
}
