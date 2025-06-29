package com.ai4everyone.tutorial.runnablecallable.callable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTaskTest {
    private static final Logger log = LoggerFactory.getLogger(FactorialTaskTest.class);
    private ExecutorService executorService;

    @BeforeEach
    public void setUp() {
        executorService = Executors.newSingleThreadExecutor();
    }

    @AfterEach
    public void cleanUp() {
        executorService.shutdown();
    }

    @Test
    public void givenPositiveNumber_whenTaskSubmitted_thenFutureResultObtained() throws ExecutionException, InterruptedException {
        log.info("FactorialTaskTest#givenPositiveNumber_whenTaskSubmitted_thenFutureResultObtained");
        FactorialTask task = new FactorialTask(4);
        Future<Integer> future = executorService.submit(task);
        assertEquals(24, future.get().intValue());
    }

    @Test
    public void givenNegativeNumber_whenGetIsCalled_thenCallableThrowsException() {
        log.info("FactorialTaskTest#givenNegativeNumber_whenGetIsCalled_thenCallableThrowsException");
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        assertThrows(ExecutionException.class, future::get);
    }

    @Test
    public void givenNegativeNumber_whenGetIsNotCalled_thenCallableDoesntThrowsException() {
        log.info("FactorialTaskTest#givenNegativeNumber_whenGetIsNotCalled_thenCallableDoesntThrowsException");
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        assertFalse(future.isDone());
    }
}
