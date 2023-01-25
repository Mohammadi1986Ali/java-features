package com.javalab.tutorial.voidtype;

import lombok.Builder;

@Builder
public record Product (String id, String name) {
}
