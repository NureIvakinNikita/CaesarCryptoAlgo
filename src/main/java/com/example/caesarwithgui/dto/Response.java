package com.example.caesarwithgui.dto;

public abstract class Response {
    protected String message;

    protected String newFilePath;

    public String getMessage() {
        return message;
    }

    public String getNewFilePath() {
        return newFilePath;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNewFilePath(String newFilePath) {
        this.newFilePath = newFilePath;
    }
}
