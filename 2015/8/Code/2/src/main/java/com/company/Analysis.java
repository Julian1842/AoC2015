package com.company;

import java.util.List;

public class Analysis {
    int charsInString = 0;
    int charsInCode = 0;

    public Analysis() {
    }

    public void calculateChars(List<String> lines) {
        calculateCharsInCode(lines);
        calculateCharsInString(lines);
    }

    public void calculateCharsInCode(List<String> lines) {
        for (String line : lines) {
            int length = line.length();
            charsInCode += length;
        }
    }

    private void calculateCharsInString(List<String> lines) {
        for (String line : lines) {
            int matches = calculateEscape(line);

            int length = line.length() + 2;

            int toAdd = length + matches;
            charsInString += toAdd;
        }
    }

    private int calculateEscape(String line) {
        char toFind1 = '\\';
        char toFind2 = '\"';

        String[] results = new String[2];

        int matches = 0;

        boolean b = line.contains(String.valueOf(toFind1)) || line.contains(String.valueOf(toFind2));

        while(b) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);

                if (currentChar == toFind1 || currentChar == toFind2) {
                    matches++;
                }

            }

            b = false;
        }

        return matches;
    }


    public int getSolution() {
        return charsInString - charsInCode;
    }

    public int getCharsInString() {
        return charsInString;
    }

    public int getCharsInCode() {
        return charsInCode;
    }
}
