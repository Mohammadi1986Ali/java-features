package com.ai4everyone.tutorial.runnablecallable.exception;

public class BusinessException extends Exception {
    private final MessageKey messageKey;

    public BusinessException(MessageKey messageKey) {
        this.messageKey = messageKey;
    }

    public MessageKey getMessageKey() {
        return messageKey;
    }
}
