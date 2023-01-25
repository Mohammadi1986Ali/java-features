package com.javalab.tutorial.voidtype;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    @Test
    void givenCalculator_whenGettingVoidMethodsByReflection_thenOnlyClearAndPrint() {
        Method[] productServiceMethods = ProductService.class.getDeclaredMethods();
        List<Method> productServiceVoidMethods = Arrays.stream(productServiceMethods)
                .filter(method -> method.getReturnType().equals(Void.TYPE))
                .collect(Collectors.toList());

        assertTrue(productServiceVoidMethods.size() == 1);
    }
}