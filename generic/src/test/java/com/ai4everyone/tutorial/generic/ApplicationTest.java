package com.ai4everyone.tutorial.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    static class GenericClass<T> {
        private T value;

        public GenericClass(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    static class Util {
        static <T> boolean compareObjects(T value1, T value2) {
            return value1.equals(value2);
        }
    }

    @Test
    void givenGenericClass_whenInstantiate_thenValueShouldBeCorrect() {
        GenericClass<Integer> genericClass = new GenericClass<>(1);
        assertEquals(Integer.valueOf(1), genericClass.getValue());
    }

    @Test
    void givenGenericClass_whenSetValue_thenValueShouldBeCorrect() {
        GenericClass<Integer> genericClass = new GenericClass<>(1);
        genericClass.setValue(2);
        assertEquals(Integer.valueOf(2), genericClass.getValue());
    }

    @Test
    void givenObjects_whenCompareObjects_thenValueShouldBeCorrect() {
        assertTrue(Util.compareObjects(10, 10));
        assertFalse(Util.compareObjects(10, "10"));
    }

    @Test
    void givenRawTypeGenericClass_whenUncheckedAssignment_thenClassCastExceptionThrown() {
        GenericClass rawGenericClass = new GenericClass<>("Some string");
        GenericClass<Integer> intGenericClass = rawGenericClass;
        assertThrows(ClassCastException.class, () -> {
            Integer value = intGenericClass.getValue();
        });
    }

    @Test
    void typeErasure() {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        assertTrue(list1.getClass() == list2.getClass());
    }
}