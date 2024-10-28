public class CaesarCypherService {

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
