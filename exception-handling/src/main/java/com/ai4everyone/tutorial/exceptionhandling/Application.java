package com.ai4everyone.tutorial.exceptionhandling;

import com.ai4everyone.tutorial.exceptionhandling.globalexceptionhandler.GlobalExceptionHandler;
import com.ai4everyone.tutorial.exceptionhandling.util.ArithmeticOperation;
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
