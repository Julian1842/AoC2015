package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<String> parseResult(String result) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);

            results.add(String.valueOf(currentChar));
        }

        return results;
    }

    public static int calculateFloor(List<String> results) {
        int floor = 0;

        for (String s : results) {
            if (s.equals("(")) {
                floor += 1;
            } else if (s.equals(")")) {
                floor -= 1;
            }
        }

        return floor;
    }
}
