package com.example.caesarwithgui.service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderService {

    public String readData(String filePath) {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please enter the correct path.");
        } catch (IOException e) {
            System.out.println("Could not read data from the file.");
        }
        return result.toString();
    }

    public String writeData(String filePath, String data, String operation) throws IOException {
        java.nio.file.Path originalPath = Paths.get(filePath);
        String fileName = originalPath.getFileName().toString();
        String newFileName = getFileNaming(fileName, operation);

        Path newFilePath = originalPath.getParent().resolve(newFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath.toFile()))) {
            writer.write(data);
            System.out.println("The data was successfully written to the file: " + newFilePath);
        } catch (IOException e) {
            throw new IOException("Failed to write to file.");
        }

        return newFilePath.toFile().getAbsolutePath();
    }

    public String getFileNaming(String fileName, String operation){
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            String nameWithoutExtension = "";
            if (fileName.contains("[")) {
                nameWithoutExtension = fileName.substring(0, fileName.indexOf("["));
            } else {
                nameWithoutExtension = fileName.substring(0, dotIndex);
            }
            String extension = fileName.substring(dotIndex);

            return nameWithoutExtension + operation + extension;
        } else {
            return fileName + operation;
        }
    }
}
