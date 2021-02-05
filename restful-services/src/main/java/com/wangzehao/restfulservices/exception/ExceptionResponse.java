package com.wangzehao.restfulservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String messages;
    private String details;

    public ExceptionResponse(Date timestamp, String messages, String details) {
        this.timestamp = timestamp;
        this.messages = messages;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessages() {
        return messages;
    }

    public String getDetails() {
        return details;
    }
}
