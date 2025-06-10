package com.mbarekdev.crudapp.rest.error;

public class ErrorResponse {
    private int statuse;
    private String message;
    private long timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int statuse, String message, long timeStamp) {
        this.statuse = statuse;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public void setStatus(int statuse) {
        this.statuse = statuse;
    }

    public int getStatuse() {
        return statuse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
