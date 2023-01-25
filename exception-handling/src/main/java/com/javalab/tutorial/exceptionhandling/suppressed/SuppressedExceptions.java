package com.javalab.tutorial.exceptionhandling.suppressed;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class SuppressedExceptions {

    public static void fileNotExist(String filePath) throws IOException {
        log.info("SuppressedExceptions#fileNotExist");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        } finally {
            fis.close();
        }
    }

    public static void addSuppressedException(String filePath) throws IOException {
        log.info("SuppressedExceptions#addSuppressedException");
        Throwable throwable = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (IOException e) {
            throwable = e;
        } finally {
            try {
                fis.close();
            } catch (NullPointerException npe) {
                if (throwable != null) {
                    npe.addSuppressed(throwable);
                }
                throw npe;
            }
        }
    }

    public static void exceptionalResource() throws Exception {
        log.info("SuppressedExceptions#exceptionalResource");
        try (ExceptionalResource exceptionalResource = new ExceptionalResource()) {
            exceptionalResource.process();
        }
    }
}
