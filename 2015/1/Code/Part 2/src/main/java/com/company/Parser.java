package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static List<String> parseResult(String result) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);

            results.add(String.valueOf(currentChar));
        }

        return results;
    }

    public static TreeMap<Integer, Integer> calculateCharacterToFloor(List<String> results) {
        int floor = 0;
        TreeMap<Integer, Integer> characterToFloor = new TreeMap<>();

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).equals("(")) {
                floor += 1;

                characterToFloor.put(i + 1, floor);
            } else if (results.get(i).equals(")")) {
                floor -= 1;

                characterToFloor.put(i + 1, floor);
            }


        }

        return characterToFloor;
    }

    public static int getFinalFloor(TreeMap<Integer, Integer> characterToFloor) {
        Map.Entry<Integer, Integer> finalEntry = characterToFloor.lastEntry();

        return finalEntry.getValue();
    }
}
