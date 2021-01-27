package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public static String readFile(String path) throws IOException {
        Path fileName = Path.of(path);
        return Files.readString(fileName);
    }
}
