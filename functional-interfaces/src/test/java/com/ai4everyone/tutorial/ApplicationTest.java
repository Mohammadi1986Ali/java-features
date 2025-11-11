package com.ai4everyone.tutorial;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    Logger log = LoggerFactory.getLogger(ApplicationTest.class);
    private final static String LOWERCASE_NAME = "name";
    private final static String UPPERCASE_NAME = "NAME";
    private final static String DESCRIPTION = "The customerNumber is: ";

    @Test
    void givenFunctions_whenComposeFunctions_thenFunctionsShouldBeRunCorrectly() {
        log.info("ApplicationTest#givenFunctions_whenDoingComposition_thenFunctionsShouldBeRunCorrectly");
        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> addDescription = inputString -> DESCRIPTION + inputString;
        Function<Integer, String> addDescriptionInToString = addDescription.compose(intToString);

        assertAll(
                () -> assertEquals("5", intToString.apply(5)),
                () -> assertTrue(addDescription.apply("5").contains(DESCRIPTION)),
                () -> assertTrue(addDescriptionInToString.apply(5).contains(DESCRIPTION))
        );
    }

    @Test
    void whenRunningOperators_thenOperatorsShouldBeRunCorrectly() {
        log.info("ApplicationTest#whenRunningOperators_thenOperatorsShouldBeRunCorrectly");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        BinaryOperator<Integer> addInteger = Integer::sum;

        assertEquals(UPPERCASE_NAME, toUpperCase.apply(LOWERCASE_NAME));
        assertEquals(10, addInteger.apply(5, 5));
    }
}
