import service.CaesarCypherService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        String command = "", filePath = "", key="";

        if (args.length == 0) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while(true) {

                    System.out.println("Введіт одну з доступних команад 1 - ENCRYPT, " +
                            "2 - DECRYPT, 3 - BRUTE_FORCE, 4 - EXIT:");

                    command = reader.readLine();
                    if (command.equals("4")) {
                        System.out.println("До побачення!");
                        break;
                    }
                    System.out.println("Введіть шлях до файлу: ");
                    filePath = reader.readLine();
                    if (command.equals("1") || command.equals("2")) {
                        System.out.println("Введіть ключ:");
                        key = reader.readLine();
                    }
                    if (command.equals("1")) {
                        CaesarCypherService.encrypt(filePath, key);
                    } else if (command.equals("2")) {
                        CaesarCypherService.decrypt(filePath, key);
                    } else if (command.equals("3")) {
                        CaesarCypherService.bruteForceDecrypt(filePath);
                    }

                }
            } catch (IOException e) {
                System.out.println("Відубался помилка під час зчитування тексту.");
            }
        }
    }
}