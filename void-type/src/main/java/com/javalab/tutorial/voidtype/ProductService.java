package com.javalab.tutorial.voidtype;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductService {

    public void addProduct() {
        log.info("Product#addProduct");
    }

    public List<Product> getProducts() {
        log.info("Product#getProducts");
        List<Product> products = new ArrayList<>();
        return products;
    }
}
