package com.mbarekdev.rest.error;

public class StudentErrorResponse {
    private int statuse;
    private String message;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int statuse, String message, long timeStamp) {
        this.statuse = statuse;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    public void setStatus(int statuse) {
        this.statuse = statuse;
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
