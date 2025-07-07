package com.ai4everyone.tutorial.exceptionhandling.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArithmeticOperation {
    private static final Logger log = LoggerFactory.getLogger(ArithmeticOperation.class);

    public static int division(int number1, int number2) {
        log.info("ArithmeticOperation#division {} and {}", number1, number2);
        return number1/number2;
    }
}
