package com.ai4everyone.tutorial.exceptionhandling;

import com.ai4everyone.tutorial.exceptionhandling.suppressedexception.AutoCloseableResource;
import com.ai4everyone.tutorial.exceptionhandling.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private final static Logger log = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    public void givenNonExistentFilePath_whenOpeningFile_thenNullPointerExceptionOccurred() throws IOException {
        log.info("ApplicationTest#givenNonExistentFilePath_whenAttemptOpeningFile_thenNullPointerExceptionOccurred");
        assertThrows(NullPointerException.class, () -> FileUtil.openFileExceptionHandling("/non-existent-path/non-existent-file.txt"));
    }

    @Test
    public void givenNonExistentFileName_whenOpeningFileSuppressedExceptionHandling_thenSuppressedExceptionAvailable() {
        try {
            FileUtil.openFileSuppressedExceptionHandling("/non-existent-path/non-existent-file.txt");
        } catch (Exception e) {
            assertAll(
                    () -> assertInstanceOf(NullPointerException.class, e),
                    () -> assertEquals(1, e.getSuppressed().length),
                    () -> assertInstanceOf(FileNotFoundException.class, e.getSuppressed()[0])
            );
        }
    }

    @Test
    public void whenUsingAutoCloseableResource_thenSuppressedExceptionAvailable() {
        try (var resource = new AutoCloseableResource()) {
            resource.process();
        } catch (Exception e) {
            assertAll(
                    () -> assertInstanceOf(IllegalArgumentException.class, e),
                    () -> assertEquals("Processing AutoCloseableResource failed", e.getMessage()),
                    () -> assertEquals(1, e.getSuppressed().length),
                    () -> assertInstanceOf(NullPointerException.class, e.getSuppressed()[0]),
                    () ->assertEquals("Closing AutoCloseableResource failed", e.getSuppressed()[0].getMessage())
            );
        }
    }
}
