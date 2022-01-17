package com.enocklubowa.springcommonexceptions.advice;

import com.enocklubowa.springcommonexceptions.exception.InvalidIdentifierException;
import com.enocklubowa.springcommonexceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Parses and returns the {@link com.enocklubowa.springcommonexceptions.exception.InvalidIdentifierException}
 * to the controller that throws it
 */
@RestControllerAdvice
public class InvalidIdentifierAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidIdentifierException.class)
    public ResponseEntity<Object> exceptionAdvice(InvalidIdentifierException exception){
        ErrorResponse error = new ErrorResponse(exception.getMessage(), null);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
