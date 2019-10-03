package me.josephzhu.springcloudk8sdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex){
        log.error("error:", ex);
        return ex.toString();
    }
}
