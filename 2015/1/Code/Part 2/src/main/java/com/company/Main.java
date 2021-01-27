package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) throws IOException {
        String result = Reader.readFile(PATH);

        List<String> results = Parser.parseResult(result);
        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        int floor = 0;

        for (Map.Entry<Integer, Integer> s: characterToFloor.entrySet()) {
            if (s.getValue() == -1) {
                floor = s.getKey();

                break;
            }
        }

        System.out.println(String.format("Reaching floor -1 on character %s", floor));
    }
}
