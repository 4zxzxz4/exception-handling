package com.example.exceptionhandling.exception;

public class NoApiException extends RuntimeException {
    public NoApiException(String message) {
        super(message);
    }
}
