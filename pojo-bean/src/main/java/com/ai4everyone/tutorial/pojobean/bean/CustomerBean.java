package com.ai4everyone.tutorial.pojobean.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(CustomerBean.class);

    private String name;
    private int age;

    public CustomerBean() {
        log.info("CustomerBean created");
    }

    public CustomerBean(String name, Integer age) {
        log.info("CustomerBean created, name: {}, age: {}", name, age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
