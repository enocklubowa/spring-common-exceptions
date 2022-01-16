package com.enocklubowa.springcommonexceptions.advice;

import com.enocklubowa.springcommonexceptions.exception.NotFoundException;
import com.enocklubowa.springcommonexceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<Object> notFoundHandler(NotFoundException exception){
        ErrorResponse error = new ErrorResponse(exception.getMessage(), null);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
