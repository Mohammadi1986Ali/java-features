package com.ai4everyone.tutorial.pojobean;

import com.ai4everyone.tutorial.pojobean.bean.CustomerBean;
import com.ai4everyone.tutorial.pojobean.pojo.CustomerPojo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    void whenCustomerBeanObjectCreated_thenCustomerBeanObjectShouldNotBeNull() {
        log.info("ApplicationTest#whenCustomerBeanObjectCreated_thenCustomerBeanObjectShouldNotBeNull");
        CustomerBean customer = new CustomerBean();
        assertNotNull(customer);
    }

    @Test
    void whenCustomerPojoObjectCreated_thenCustomerPojoObjectShouldNotBeNull() {
        log.info("ApplicationTest#whenCustomerPojoObjectCreated_thenCustomerPojoObjectShouldNotBeNull");
        CustomerPojo customer = new CustomerPojo("Ali", 30);
        assertNotNull(customer);
    }
}