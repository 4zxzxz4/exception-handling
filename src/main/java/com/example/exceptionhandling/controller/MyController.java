package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.config.ErrorMessage;
import com.example.exceptionhandling.exception.InvalidParameterException;
import com.example.exceptionhandling.exception.NoApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MyController {

    @Value("${reason.no-version-api}")
    String NO_VERSION_API;

    @GetMapping("hello")
    public void hello() {
        throw new NoApiException("하나의 컨트롤러에 적용되는 에러 발생");
    }

    @PostMapping("/helloAll")
    public void helloAll(String toName) {
        if(StringUtils.isEmpty(toName))
            throw new InvalidParameterException("모든 컨트롤러에 적용되는 에러 발생");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NoApiException.class })
    public ErrorMessage handlePerControllerException(RuntimeException ex) {
        log.error(ex.toString());
        return new ErrorMessage(NO_VERSION_API);
    }
}
