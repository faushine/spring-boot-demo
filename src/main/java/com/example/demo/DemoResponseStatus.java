package com.example.demo;

public enum DemoResponseStatus {
    MESSAGE_FOUND("2003001", "Message found"),
    MESSAGE_NOT_FOUND("4003003", "Message not found");
    private String appCode;
    private String message;

    public String getAppCode() {
        return this.appCode;
    }

    public String getMessage() {
        return this.message;
    }
    DemoResponseStatus(String appCode, String message) {
        this.appCode = appCode;
        this.message = message;
    }
}
