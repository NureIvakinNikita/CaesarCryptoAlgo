package service;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

public class CaesarCypherService {

    private static final Set<String> DICTIONARY = new HashSet<>();

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
    }


    public static String encrypt(String filePath, String key) {
        String data = FileReaderService.readData(filePath);
        int offset = Integer.parseInt(key);
        String res = encryptEngData(data, offset);
        FileReaderService.writeData(filePath, res, "[ENCRYPT]");
        return res;
    }

    public static void decrypt(String filePath, String key){
        String data = FileReaderService.readData(filePath);
        int offset = Integer.parseInt(key);
        String res = decryptEngData(data, offset);
        FileReaderService.writeData(filePath, res, "[DECRYPT]");
    }

    public static String encryptEngData(String inputData, int offset) {
        inputData = inputData.toLowerCase();
        StringBuilder encryptData = new StringBuilder();
        for (char character : inputData.toCharArray()) {
            if (Character.isLetter(character)) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                encryptData.append(newCharacter);
            } else {
                encryptData.append(character);
            }
        }
        return encryptData.toString();
    }

    public static String decryptEngData(String inputData, int offset) {
        return encryptEngData(inputData, 26 - (offset % 26));
    }

    public static void bruteForceDecrypt(String filePath) {
        String encryptedData = FileReaderService.readData(filePath);
        System.out.println("Результати брутфорс-розшифровки:");
        for (int key = 1; key < 26; key++) {
            String decryptedData = decryptEngData(encryptedData, key);
            if (isReadable(decryptedData)) {
                System.out.println("Ключ: " + key + " - " + decryptedData);
                FileReaderService.writeData(filePath, decryptedData, "[ENCRYPT]");
            }
        }
    }

    private static boolean isReadable(String text) {
        for (String word : DICTIONARY) {
            if (text.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
