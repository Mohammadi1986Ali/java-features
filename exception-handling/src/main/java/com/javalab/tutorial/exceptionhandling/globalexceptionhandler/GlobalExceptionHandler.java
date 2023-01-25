package com.javalab.tutorial.exceptionhandling.globalexceptionhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalExceptionHandler {

    public int performArithmeticOperation(int number_1, int number_2) {
        log.info("GlobalExceptionHandler#performArithmeticOperation");
        return number_1/number_2;
    }
}
