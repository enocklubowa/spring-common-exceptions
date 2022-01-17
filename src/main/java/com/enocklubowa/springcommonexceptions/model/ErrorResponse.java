package com.enocklubowa.springcommonexceptions.model;

import java.util.Date;
import java.util.List;

/**
 * The error body returned by controllers when exceptions are thrown
 */
public class ErrorResponse {
    private String message;
    private List<String> details;
    private Date timestamp;

    public ErrorResponse(String message, List<String> details){
        this.message = message;
        this.details = details;
        timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", details=" + details +
                ", timestamp=" + timestamp +
                '}';
    }
}
