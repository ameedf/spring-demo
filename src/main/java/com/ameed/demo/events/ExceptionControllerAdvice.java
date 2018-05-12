package com.ameed.demo.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ameed_fah
 * 10/05/2018
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Bla bla")
    public String exception(Exception e) {
        return e.getMessage();
    }
}