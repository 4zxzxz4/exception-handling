package com.example.exceptionhandling.config;

public class ErrorMessage {
    private String reason;

    public ErrorMessage(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return reason;
    }
}
