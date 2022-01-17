package com.enocklubowa.springcommonexceptions.exception;

/**
 * Exception that should be shown when there is an error that you wouldn't want to share with clients
 * or when an unexpected error occurs.
 */
public class GeneralException extends RuntimeException {

    /**
     * Throw default exception with default message
     */
    public GeneralException(){}

    /**
     * Throw exception with specified message
     * @param message
     */
    public GeneralException(String message){
        super(message);
    }
}
