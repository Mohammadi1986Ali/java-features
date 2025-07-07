package com.ai4everyone.tutorial.exceptionhandling.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static void openFileExceptionHandling(String filePath) throws IOException {
        log.info("FileUtil#openFileHandlingException");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        } finally {
            fis.close();
        }
    }

    public static void openFileSuppressedExceptionHandling(String filePath) throws IOException {
        log.info("FileUtil#openFileSuppressedExceptionHandling");
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
}
