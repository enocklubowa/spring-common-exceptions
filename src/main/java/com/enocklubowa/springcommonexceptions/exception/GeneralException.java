package com.enocklubowa.springcommonexceptions.exception;

public class GeneralException extends RuntimeException {

    public GeneralException(){}

    public GeneralException(String message){
        super(message);
    }
}
