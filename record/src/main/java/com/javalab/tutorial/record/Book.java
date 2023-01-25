package com.javalab.tutorial.record;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Book(String bookId, Instant createDate, String name, String writer) implements BaseInformation {

    public static String UNNAMED = "Unnamed";
    public static String UNKNOWN_WRITER = "Unknown";

    public Book {
        Objects.requireNonNull(name);
        Objects.requireNonNull(writer);
    }

    public Book(String name, String writer) {
        this(UUID.randomUUID().toString(), Instant.now(), name, writer);
    }

    public static Book createUnnamed(String writer) {
        return new Book(UUID.randomUUID().toString(), Instant.now(), UNNAMED, writer);
    }

    public static Book createUnknownWriter(String name) {
        return new Book(UUID.randomUUID().toString(), Instant.now(), name, UNKNOWN_WRITER);
    }
}
