package com.ai4everyone.tutorial.voidtype.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralServiceImpl implements GeneralService {
    private static final Logger log = LoggerFactory.getLogger(GeneralServiceImpl.class);

    @Override
    public String getString() {
        log.info("GeneralServiceImpl#getString");
        return "String";
    }

    @Override
    public Void getVoid() {
        log.info("GeneralServiceImpl#getVoid");
        return null;
    }

    @Override
    public Integer getInteger() {
        log.info("GeneralServiceImpl#getInteger");
        return 0;
    }

    @Override
    public void getNothing() {
        log.info("GeneralServiceImpl#getNothing");
    }
}
