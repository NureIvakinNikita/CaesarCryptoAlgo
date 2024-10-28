public class CaesarCypherService {


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


}
