package com.company;

import java.util.List;

public class Analysis {
    public static boolean isStringNice(String line) {
        return (containsThreeVowels(line) && containsLettersTwiceInARow(line) && !containsForbiddenStrings(line));
    }

    private static boolean containsThreeVowels(String line) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        int vowelCount = 0;

        for (int i = 0; i < line.length(); i++) {
            Character currentChar = line.charAt(i);

            for (Character vowel : vowels) {
                if (currentChar.equals(vowel)) {
                    vowelCount++;
                }
            }
        }

        return vowelCount >= 3;
    }

    private static boolean containsLettersTwiceInARow(String line) {
        Character lastChar = line.charAt(0);

        for (int i = 1; i < line.length(); i++) {
            Character currentChar = line.charAt(i);

            if (currentChar.equals(lastChar)) {
                return true;
            }

            lastChar = currentChar;
        }

        return false;
    }

    private static boolean containsForbiddenStrings(String line) {
        List<String> forbiddenStrings = List.of("ab", "cd", "pq", "xy");

        for (String s : forbiddenStrings) {
            if (line.contains(s)) {
                return true;
            }
        }

        return false;
    }
}
