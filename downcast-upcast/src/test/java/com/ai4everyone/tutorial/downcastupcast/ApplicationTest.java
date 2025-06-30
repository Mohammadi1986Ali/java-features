package com.ai4everyone.tutorial.downcastupcast;

import com.ai4everyone.tutorial.downcastupcast.model.ChildClass;
import com.ai4everyone.tutorial.downcastupcast.model.ParentClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    public void whenUpcastingObjects_thenObjectsShouldBehaveCorrectly() {
        ParentClass parent = new ChildClass();
        parent.parentName = "parentName";
        assertNull(parent.getName());
    }

    @Test
    public void whenDowncastingObjects_thenObjectsShouldBehaveCorrectly() {
        ParentClass parentClass = new ChildClass();
        ChildClass childClass = (ChildClass) parentClass;
        childClass.childName = "childName";
        assertEquals("childName", parentClass.getName());
    }
}
