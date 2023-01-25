package com.javalab.tutorial.exceptionhandling.suppressed;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionalResource implements AutoCloseable {

    public void process() {
        log.info("ExceptionalResource#process");
        throw new IllegalArgumentException("Thrown exception from process()");
    }

    @Override
    public void close() throws Exception {
        log.info("ExceptionalResource#close");
        throw new NullPointerException("Thrown null pointer exception from close()");
    }
}
