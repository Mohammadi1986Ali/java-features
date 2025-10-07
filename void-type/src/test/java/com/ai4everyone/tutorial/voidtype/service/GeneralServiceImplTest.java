package com.ai4everyone.tutorial.voidtype.service;

import com.ai4everyone.tutorial.voidtype.util.ClassUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class GeneralServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(GeneralServiceImplTest.class);

    @Test
    void whenGettingVoidMethodsByReflection_thenOnlyVoidMethodsShouldBeReturned() {
        log.info("GeneralServiceImplTest#whenGettingVoidMethodsByReflection_thenOnlyVoidMethodsShouldBeReturned");
        var methods = ClassUtils.getMethodsByReturnType(GeneralServiceImpl.class, Void.TYPE);
        assertEquals(1, methods.size());
    }

    @Test
    void whenGettingVoidObjectMethodsByReflection_thenOnlyVoidObjectMethodsShouldBeReturned() {
        log.info("GeneralServiceImplTest#whenGettingVoidObjectMethodsByReflection_thenOnlyVoidObjectMethodsShouldBeReturned");
        var methods = ClassUtils.getMethodsByReturnType(GeneralServiceImpl.class, Void.class);
        assertEquals(1, methods.size());
    }
}
