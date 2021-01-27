package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static boolean isStringNice(String line) {
        return (containsLetterPairs(line) && containsRepeatingLetter(line));
    }

    private static boolean containsLetterPairs(String line) {
        char lastChar = line.charAt(0);

        List<String> subStrings = new ArrayList<>();

        String chars = "";

        for (int i = 1; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            subStrings.add(Character.toString(lastChar) + Character.toString(currentChar));

            lastChar = currentChar;
        }

        return containsMultipleOccurencesOfSameLetterPair(line, subStrings);
    }

    public static boolean containsMultipleOccurencesOfSameLetterPair(String line, List<String> subStrings) {
        for (String stringToFind : subStrings) {
            int count = line.length() - line.replaceAll(stringToFind,"").length();

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsRepeatingLetter(String line) {
       for (int i = 0; i < line.length(); i++) {
           char currentChar = line.charAt(i);

           if (i + 2 < line.length()) {
               char futureChar = line.charAt(i + 2);

               if (currentChar == futureChar) {
                   return true;
               }
           }
       }

       return false;
    }
}
