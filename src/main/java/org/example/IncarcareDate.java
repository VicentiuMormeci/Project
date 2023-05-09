package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class IncarcareDate {
    public static final String CosCumparaturi_FILE_PATH = "CosCumparaturi.csv";
    public static final String metodaPlata_FILE_PATH = "metodaPlata.csv";
    public static List<String> readFile(String filePathStr) throws IOException {
        Path path = Paths.get(filePathStr);
        return Files.readAllLines(path);
    }
    public static void writeFile(String filePathStr, String content) throws IOException {
        Path path = Paths.get(filePathStr);

        Files.write(path,content.getBytes());
    }

}
