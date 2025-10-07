package com.ai4everyone.tutorial.record.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Book(String bookId, Instant createdAt, String name, String writer) implements BookBaseInformation {
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
