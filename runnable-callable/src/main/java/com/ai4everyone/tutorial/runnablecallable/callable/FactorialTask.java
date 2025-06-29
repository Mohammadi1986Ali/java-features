package com.ai4everyone.tutorial.runnablecallable.callable;

import com.ai4everyone.tutorial.runnablecallable.exception.BusinessException;
import com.ai4everyone.tutorial.runnablecallable.exception.MessageKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    private static final Logger log = LoggerFactory.getLogger(FactorialTask.class);
    private final int number;

    public FactorialTask(int number) {
        log.info("FactorialTask created, number: {}", number);
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        log.info("FactorialTask#call, number: {}", number);
        int factorial = 1;
        if (number < 0) {
            throw new BusinessException(MessageKey.INVALID_PARAMETER);
        }
        for (int count = number; count > 0; count--) {
            factorial *= count;
        }
        return factorial;
    }
}
