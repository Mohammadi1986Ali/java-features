package com.ai4everyone.tutorial.downcastupcast.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass {
    private static final Logger log = LoggerFactory.getLogger(ParentClass.class);
    public String parentName;

    public String getName() {
        log.info("ParentClass#getName");
        return parentName;
    }
}
