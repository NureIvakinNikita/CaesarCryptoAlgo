package com.example.caesarwithgui.dto;

public class DecryptionResponse extends Response {
    public DecryptionResponse(String message, String newFilePath) {
        this.message = message;
        this.newFilePath = newFilePath;
    }
}
