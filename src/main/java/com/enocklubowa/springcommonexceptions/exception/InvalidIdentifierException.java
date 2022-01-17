package com.enocklubowa.springcommonexceptions.exception;

/**
 * Exception that should be shown when an invalid identifier is provided for example
 * if an invalid id is provided when trying to get user details
 */
public class InvalidIdentifierException extends RuntimeException{

    /**
     * Throw exception with details about the invalid identifier
     * @param identifier
     */
    public InvalidIdentifierException(String identifier){
        super(String.format("The specified identifier :%s is invalid", identifier));
    }

    /**
     * Throw exception with details about the invalid identifier
     * @param identifier
     */
    public InvalidIdentifierException(Long identifier){
        super(String.format("The specified identifier :%d is invalid", identifier));
    }

}
