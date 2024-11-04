package com.example.caesarwithgui.service;

import com.example.caesarwithgui.dto.BruteForceResponse;
import com.example.caesarwithgui.dto.DecryptionResponse;
import com.example.caesarwithgui.dto.EncryptionResponse;


import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

public class CaesarCypherService {

    private static final Set<String> DICTIONARY = new HashSet<>();
    private static final String ALL_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,«»\"':!? ";


    static {
        DICTIONARY.add("the");
        DICTIONARY.add("and");
        DICTIONARY.add("you");
        DICTIONARY.add("but");
        DICTIONARY.add("is");
        DICTIONARY.add("are");
        DICTIONARY.add("has");
        DICTIONARY.add("have");
        DICTIONARY.add("that");
        DICTIONARY.add("for");
        DICTIONARY.add("not");
        DICTIONARY.add("with");
        DICTIONARY.add("this");
        DICTIONARY.add("his");
        DICTIONARY.add("will");
        DICTIONARY.add("was");
        DICTIONARY.add("were");
        DICTIONARY.add("from");
        DICTIONARY.add("they");
        DICTIONARY.add("he");
        DICTIONARY.add("she");
        DICTIONARY.add("her");
        DICTIONARY.add("what");
        DICTIONARY.add("would");
        DICTIONARY.add("so");
        DICTIONARY.add("an");
        DICTIONARY.add("all");
        DICTIONARY.add("out");
        DICTIONARY.add("who");
        DICTIONARY.add("which");
        DICTIONARY.add("can");
        DICTIONARY.add("could");
        DICTIONARY.add("must");
        DICTIONARY.add("should");
        DICTIONARY.add("to");
        DICTIONARY.add("hello");
        DICTIONARY.add("hi");
        DICTIONARY.add("good day");
        DICTIONARY.add("good evening");
        DICTIONARY.add("good afternoon");
    }


    public static EncryptionResponse encrypt(String filePath, String key) {
        String data = com.example.caesarwithgui.service.FileReaderService.readData(filePath);
        int offset = Integer.parseInt(key);
        String res = encryptEngData(data, offset);
        String newFilePath = FileReaderService.writeData(filePath, res, "[ENCRYPT]");
        return new EncryptionResponse("Encryption was successful.","Path to the file: "+newFilePath);
    }

    public static DecryptionResponse decrypt(String filePath, String key){
        String data = FileReaderService.readData(filePath);
        int offset = Integer.parseInt(key);
        String res = decryptEngData(data, offset);
        String newFilePath = FileReaderService.writeData(filePath, res, "[DECRYPT]");
        return new DecryptionResponse("Decryption was successful.","Path to the file: "+newFilePath);
    }


    public static String encryptEngData(String inputData, int offset) {
        StringBuilder encryptData = new StringBuilder();
        for (char character : inputData.toCharArray()) {
            int index = ALL_SYMBOLS.indexOf(character);
            if (index != -1) {
                int newIndex = (index + offset) % ALL_SYMBOLS.length();
                encryptData.append(ALL_SYMBOLS.charAt(newIndex));
            } else {
                encryptData.append(character);
            }
        }
        return encryptData.toString();
    }

    public static String decryptEngData(String inputData, int offset) {
        StringBuilder decryptData = new StringBuilder();
        for (char character : inputData.toCharArray()) {
            int index = ALL_SYMBOLS.indexOf(character);
            if (index != -1) {
                int newIndex = (index - offset) % ALL_SYMBOLS.length();
                if (newIndex < 0) {
                    newIndex += ALL_SYMBOLS.length();
                }
                decryptData.append(ALL_SYMBOLS.charAt(newIndex));
            } else {
                decryptData.append(character);
            }
        }
        return decryptData.toString();
    }


    public static BruteForceResponse bruteForceDecrypt(String filePath) {
        String encryptedData = FileReaderService.readData(filePath);

        for (int key = 1; key < 26; key++) {
            String decryptedData = decryptEngData(encryptedData, key);
            if (isReadable(decryptedData)) {
                System.out.print("Результати брутфорс-розшифровки:");
                System.out.println("Ключ: " + key + " - " + decryptedData);
                String newFilePath = FileReaderService.writeData(filePath, decryptedData, "[BRUTE_FORCE]");
                return new BruteForceResponse("Key: "+key, "Brute force was successful.", "Path to the file: "+newFilePath);
            }
        }
        return  new BruteForceResponse("Не вдалося декодувати перевірте чи надаєте ви закодований файл або використовується інше кодування.");
    }

    private static boolean isReadable(String text) {
        for (String word : DICTIONARY) {
            if (text.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }
}
