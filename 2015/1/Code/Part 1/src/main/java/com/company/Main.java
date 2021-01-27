package com.company;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) throws IOException {
        String result = Reader.readFile(PATH);

        List<String> results = Parser.parseResult(result);
        int floor = Parser.calculateFloor(results);

        System.out.println(String.format("Ending on floor %s", floor));
    }
}
