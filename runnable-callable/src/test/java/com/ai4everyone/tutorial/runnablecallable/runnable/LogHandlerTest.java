package com.ai4everyone.tutorial.runnablecallable.runnable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LogHandlerTest {
    private static final Logger log = LoggerFactory.getLogger(LogHandlerTest.class);
    private static ExecutorService executorService;

    @BeforeAll
    public static void setup() {
        executorService = Executors.newCachedThreadPool();
    }

    @AfterAll
    public static void cleanup() {
        executorService.shutdown();
    }

    @Test
    public void givenRunnable_whenRunIt_thenShouldBeRun() throws Exception {
        log.info("LogHandlerTest#givenRunnable_whenRunIt_thenShouldBeRun");
        Thread thread = new Thread(new LogHandler("LogHandler is running"));
        thread.start();
        thread.join();
    }

    @Test
    public void givenRunnable_whenSubmitToExecutiveService_thenShouldBeRun() throws Exception {
        log.info("LogHandlerTest#givenRunnable_whenSubmitToExecutiveService_thenShouldBeRun");
        executorService.submit(new LogHandler("LogHandler is running")).get();
    }

    @Test
    public void givenRunnableLambda_whenSubmitToExecutiveService_thenShouldBeRun() throws Exception{
        log.info("LogHandlerTest#givenRunnableLambda_whenSubmitToExecutiveService_thenShouldBeRun");
        executorService.submit(() -> log.info("Task is running")).get();
    }
}
