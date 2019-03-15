package com.example.exceptionhandling.config;

import com.example.exceptionhandling.exception.InvalidParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @Value("${reason.no-parameter}")
    String NO_PARAMETER;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ InvalidParameterException.class })
    public ErrorMessage handlePerControllerException(RuntimeException ex) {
        log.error(ex.toString());
        return new ErrorMessage(NO_PARAMETER);
    }
}
