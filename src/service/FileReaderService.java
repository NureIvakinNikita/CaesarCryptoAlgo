package service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderService {

    public static String readData(String filePath) {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено вкажіть правилний шлях.");
        } catch (IOException e) {
            System.out.println("не вдалося прочитати дані з файлую");
        }
        return result.toString();
    }

    public static void writeData(String filePath, String data, String operation) {
        java.nio.file.Path originalPath = Paths.get(filePath);
        String fileName = originalPath.getFileName().toString();
        String newFileName;

        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            String nameWithoutExtension = "";
            if (fileName.contains("[")) {
                nameWithoutExtension = fileName.substring(0, fileName.indexOf("["));
            } else {
                nameWithoutExtension = fileName.substring(0, dotIndex);
            }
            String extension = fileName.substring(dotIndex);

            newFileName = nameWithoutExtension + operation + extension;
        } else {

            newFileName = fileName + operation;
        }

        Path newFilePath = originalPath.getParent().resolve(newFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath.toFile()))) {
            writer.write(data);
            System.out.println("Дані успішно записані у файл: " + newFilePath);
        } catch (IOException e) {
            System.out.println("Не вдалося зробити запис у файл");
        }
    }
}
