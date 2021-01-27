package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static String calculate(String input) {
        int count = 1;
        List<String[]> values = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char nextChar = ' ';

            if (i + 1 < input.length()) {
                nextChar = input.charAt(i + 1);
            }

            if (currentChar == nextChar) {
                count++;
            } else {
                values.add(new String[]{String.valueOf(count), String.valueOf(currentChar)});
                count = 1;
            }
        }

        return buildString(values);
    }

    private static String buildString(List<String[]> values) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.size(); i++) {
            String[] currentValue = values.get(i);

            sb.append(currentValue[0]).append(currentValue[1]);
        }

        return sb.toString();
    }
}
