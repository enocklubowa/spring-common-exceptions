package com.enocklubowa.springcommonexceptions.advice;

import com.enocklubowa.springcommonexceptions.exception.AlreadyExistsException;
import com.enocklubowa.springcommonexceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AlreadyExistsAdvice {

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseBody
    ResponseEntity<Object> notFoundAdvice(AlreadyExistsException exception){
        ErrorResponse error = new ErrorResponse(exception.getMessage(), null);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
