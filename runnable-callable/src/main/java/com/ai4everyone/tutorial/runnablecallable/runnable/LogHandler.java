package com.ai4everyone.tutorial.runnablecallable.runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHandler implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(LogHandler.class);
    private final String message;

    public LogHandler(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        log.info(message);
    }
}
