package com.javalab.tutorial.exceptionhandling;

import com.javalab.tutorial.exceptionhandling.globalexceptionhandler.GlobalExceptionHandler;
import com.javalab.tutorial.exceptionhandling.globalexceptionhandler.MyHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Application#main");

        MyHandler handler = new MyHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new GlobalExceptionHandler().performArithmeticOperation(10, 0);
    }
}
