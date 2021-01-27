package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static List<String> readFile(String path) throws IOException {
        Path fileName = Path.of(path);
        String s = Files.readString(fileName);

        return splitLine(s);
    }

    private static List<String> splitLine(String line) {
        return Arrays.asList(line.split(""));
    }
}
