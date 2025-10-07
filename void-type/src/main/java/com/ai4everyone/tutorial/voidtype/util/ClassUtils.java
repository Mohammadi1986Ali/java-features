package com.ai4everyone.tutorial.voidtype.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {
    public static List<Method> getMethodsByReturnType(Class<?> targetClass, Class<?> returnType) {
        return Arrays.stream(targetClass.getDeclaredMethods())
                .filter(method -> method.getReturnType().equals(returnType))
                .toList();
    }
}
