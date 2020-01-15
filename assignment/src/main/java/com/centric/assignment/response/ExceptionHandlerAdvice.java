package com.centric.assignment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by bilal on 2018-07-02.
 */
@ControllerAdvice
class ExceptionHandlerAdvice {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleServiceException(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(e.getMessage()));
    }

}
