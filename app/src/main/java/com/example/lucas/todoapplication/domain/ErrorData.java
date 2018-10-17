package com.example.lucas.todoapplication.domain;

public class ErrorData {
    private String message;

    public ErrorData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
