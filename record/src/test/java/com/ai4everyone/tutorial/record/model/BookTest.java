package com.ai4everyone.tutorial.record.model;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private static final Logger log = LoggerFactory.getLogger(BookTest.class);

    @Test
    public void givenSameNameAndWriter_whenEquals_thenBooksNameAndWriterShouldBeEqual() {
        log.info("BookTest#givenSameNameAndWriter_whenEquals_thenBooksNameAndWriterShouldBeEqual");
        Book book1 = new Book("someBook", "someWriter");
        Book book2 = new Book("someBook", "someWriter");

        assertEquals(book1.name(), book2.name());
        assertEquals(book1.writer(), book2.writer());
    }

    @Test
    public void givenJustWriter_whenCreateBook_thenUnnamedBookShouldBeCreated() {
        log.info("BookTest#givenJustWriter_whenCreateBook_thenUnnamedBookShouldBeCreated");
        Book book = Book.createUnnamed("someWriter");
        assertEquals("Unnamed", book.name());
        assertEquals("someWriter", book.writer());
    }

    @Test
    public void givenJustName_whenCreateBook_thenUnknownWriterBookShouldBeCreated() {
        log.info("BookTest#givenJustName_whenCreateBook_thenUnknownWriterBookShouldBeCreated");
        Book book = Book.createUnknownWriter("someBook");

        assertEquals("someBook", book.name());
        assertEquals("Unknown", book.writer());
    }
}
