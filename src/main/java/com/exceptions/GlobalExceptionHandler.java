package com.exceptions;

import com.movies.models.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by DostM on 6/14/2020.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseData> handleConstraintViolationException(ConstraintViolationException ex) {
       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseData.builder().message(ex.getMessage()).success(Boolean.FALSE).data(ex.getStackTrace())
               .build());
    }

  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName =  ((FieldError)error).getField();
            String errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });

        logger.error("Not Valid Error Occured, and errors are {}", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseData.builder()
                .success(Boolean.FALSE)
                .data(errors)
                .build()
        );
    }


    @ExceptionHandler(ResourceNotFoundErros.class)
    public ResponseEntity<ResponseData> handleResourcenotfound(ResourceNotFoundErros ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ResponseData.builder().success(Boolean.FALSE).data(ex.getMessage()).build());

    }
}
