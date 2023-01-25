package com.javalab.tutorial.exceptionhandling.suppressed;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

class SuppressedExceptionsTest {
    @Test
    public void givenNonExistentFileName_whenAttemptFileOpen_thenNullPointerException() throws IOException {

        assertThatThrownBy(() ->
                SuppressedExceptions.fileNotExist("/non-existent-path/non-existent-file.txt")
        ).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void givenNonExistentFileName_whenAttemptFileOpenStoreSuppressed_thenSuppressedExceptionAvailable() {
        try {
            SuppressedExceptions.addSuppressedException("/non-existent-path/non-existent-file.txt");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NullPointerException.class);
            assertThat(e.getSuppressed().length).isEqualTo(1);
            assertThat(e.getSuppressed()[0]).isInstanceOf(FileNotFoundException.class);
        }
    }

    @Test
    public void whenUsingExceptionalResource_thenSuppressedExceptionAvailable() {
        try {
            SuppressedExceptions.exceptionalResource();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).isEqualTo("Thrown exception from process()");
            assertThat(e.getSuppressed().length).isEqualTo(1);
            assertThat(e.getSuppressed()[0]).isInstanceOf(NullPointerException.class);
            assertThat(e.getSuppressed()[0].getMessage()).isEqualTo("Thrown null pointer exception from close()");
        }
    }
}