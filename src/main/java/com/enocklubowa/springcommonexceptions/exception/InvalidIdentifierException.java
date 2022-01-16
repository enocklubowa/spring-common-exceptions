package com.enocklubowa.springcommonexceptions.exception;

public class InvalidIdentifierException extends RuntimeException{

    public InvalidIdentifierException(String identifier){
        super(String.format("The specified identifier :%s is invalid", identifier));
    }

    public InvalidIdentifierException(Long identifier){
        super(String.format("The specified identifier :%d is invalid", identifier));
    }

}
