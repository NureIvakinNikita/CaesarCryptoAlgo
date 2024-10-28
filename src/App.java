import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        String command = "", filePath = "", key="";

        if (args.length == 0) {
            System.out.println("Для виходу з програми введіть 4.");
            while(true) {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    if (reader.readLine().equals("4")) {
                        System.out.println("До побачення!");
                        break;
                    }
                    System.out.println("Введіт одну з доступних команад 1 - ENCRYPT, " +
                            "2 - DECRYPT, 3 - BRUTE_FORCE:");
                    command = reader.readLine();
                    System.out.println("Введіть шлях до файлу: ");
                    filePath = reader.readLine();
                    if (command.equals("1") || command.equals("2")) {
                        key = reader.readLine();
                    }
                    if (command.equals("1")) {
                        CaesarCypherService.encryptEngData("", 0);
                    } else if (command.equals("2")) {
                        CaesarCypherService.decryptEngData("", 0);
                    } else if (command.equals("3")) {
                        ///Add BrutForce
                    }
                } catch (IOException e) {
                    System.out.println("Відубался помилка під час зчитування тексту.");
                }
            }
        }
    }
}