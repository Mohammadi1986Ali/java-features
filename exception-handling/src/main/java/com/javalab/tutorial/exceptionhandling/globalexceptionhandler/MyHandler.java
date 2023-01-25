package com.javalab.tutorial.exceptionhandling.globalexceptionhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.info("MyHandler#uncaughtException");
        log.info("Unhandled exception caught!");
    }
}
