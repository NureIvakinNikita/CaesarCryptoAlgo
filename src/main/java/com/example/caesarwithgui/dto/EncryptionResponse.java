package com.example.caesarwithgui.dto;

public class EncryptionResponse extends Response{
    public EncryptionResponse(String message, String newFilePath) {
        this.message = message;
        this.newFilePath = newFilePath;
    }

    @Override
    public String toString() {
        return "Encryption response: "+ message + ".\n"+
                "Path of the encrypted file: " + newFilePath + ".\n";
    }
}
