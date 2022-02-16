package com.enocklubowa.springcommonexceptions.advice;

import com.enocklubowa.springcommonexceptions.exception.GeneralException;
import com.enocklubowa.springcommonexceptions.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses and returns the {@link com.enocklubowa.springcommonexceptions.exception.GeneralException}
 * to the controller that throws it.
 */
@ControllerAdvice
public class GeneralExceptionAdvice {

    @ExceptionHandler(GeneralException.class)
    ResponseEntity<Object> generalExceptionAdvice(GeneralException exception){
        ErrorResponse error;
        try{
            error = new ErrorResponse(exception.getMessage(), null);
        }
        catch (Exception ex){
            error = new ErrorResponse("Internal error", null);
        }
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
