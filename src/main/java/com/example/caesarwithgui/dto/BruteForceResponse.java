package com.example.caesarwithgui.dto;

public class BruteForceResponse extends Response{
    private String key;

    public BruteForceResponse(String message) {
        this.message = message;
    }

    public BruteForceResponse(String key, String message, String newFilePath) {
        this.key = key;
        this.message = message;
        this.newFilePath = newFilePath;
    }
}
