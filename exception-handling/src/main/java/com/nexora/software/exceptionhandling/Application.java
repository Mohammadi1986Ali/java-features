package com.nexora.software.exceptionhandling;

import com.nexora.software.exceptionhandling.globalexceptionhandler.GlobalExceptionHandler;
import com.nexora.software.exceptionhandling.util.ArithmeticOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("Application#main");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        ArithmeticOperation.division(10, 0);
    }
}
