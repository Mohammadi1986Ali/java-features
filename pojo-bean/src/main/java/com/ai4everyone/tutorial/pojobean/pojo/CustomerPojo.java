package com.ai4everyone.tutorial.pojobean.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerPojo {
    private static final Logger log = LoggerFactory.getLogger(CustomerPojo.class);

    public String name;
    public Integer age;

    public CustomerPojo(String name, Integer age) {
        log.info("CustomerPojo created, name: {}, age: {}", name, age);
        this.name = name;
        this.age = age;
    }
}
