package com.example.demo;

public class HelloResponse {
    private String message;
    private int count;

    public HelloResponse(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public String getMessage() {
        return message;
    }
    public int getCount() {
        return count;
    }
}
