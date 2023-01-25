package com.javalab.tutorial.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookUnitTest {

    @Test
    public void givenSameNameAndWriter_whenEquals_thenBooksNameAndWriterEqual() {
        Book book1 = new Book("someBook", "someWriter");
        Book book2 = new Book("someBook", "someWriter");

        assertEquals(book1.name(), book2.name());
        assertEquals(book1.writer(), book2.writer());
    }

    @Test
    public void givenJustWriter_whenCreateBook_thenUnnamedBooksShouldBeCreated() {
        Book book = Book.createUnnamed("someWriter");
        assertEquals(book.name(), "Unnamed");
        assertEquals(book.writer(), "someWriter");
    }

    @Test
    public void givenJustName_whenCreateBook_thenUnknownWriterBooksShouldBeCreated() {
        Book book = Book.createUnknownWriter("someBook");

        assertEquals(book.name(), "someBook");
        assertEquals(book.writer(), "Unknown");
    }
}