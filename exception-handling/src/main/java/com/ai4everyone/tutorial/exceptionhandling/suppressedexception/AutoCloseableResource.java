package com.ai4everyone.tutorial.exceptionhandling.suppressedexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoCloseableResource implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(AutoCloseableResource.class);

    public void process() {
        log.info("AutoCloseableResource#process");
        throw new IllegalArgumentException("Processing AutoCloseableResource failed");
    }

    @Override
    public void close() {
        log.info("AutoCloseableResource#close");
        throw new NullPointerException("Closing AutoCloseableResource failed");
    }
}
