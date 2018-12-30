package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageInfo {
    @JsonProperty("DemoResponseStatus")
    private String status;

    @JsonProperty("Hint")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String hint;

    public MessageInfo(DemoResponseStatus responseStatus) {
        this(responseStatus, responseStatus.getMessage());
    }

    public MessageInfo(DemoResponseStatus responseStatus, String customMessage) {
        this.status = responseStatus.getAppCode();
        this.hint = customMessage;
    }
}
