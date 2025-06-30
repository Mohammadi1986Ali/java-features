package com.ai4everyone.tutorial.downcastupcast.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChildClass extends ParentClass {
    private static final Logger log = LoggerFactory.getLogger(ChildClass.class);
    public String childName;

    @Override
    public String getName() {
        log.info("ChildClass#getName");
        return childName;
    }
}
