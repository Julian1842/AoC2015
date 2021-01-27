package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            int totalSize = line.length();

            String[] results1;
            String[] results2;
            String[] results3;

            results1 = calculateFirstEscape(line);
            results2 = calculateSecondEscape(results1[0]);
            results3 = calculateThirdEscape(results2[0]);

            int totalMatches = Integer.parseInt(results1[1]) + Integer.parseInt(results2[1]) + Integer.parseInt(results3[1]);

            int newLength = results3[0].length() - 2;

            int toAdd = (newLength + totalMatches);
            charsInString += toAdd;
        }
    }

    private String[] calculateFirstEscape(String line) {
        String copiedLine = line;
        char toFind = '\\';

        String[] results = new String[2];

        ArrayList<Integer> charIndexesToRemove = new ArrayList<>();

        int matches = 0;

        boolean b = copiedLine.contains("\\\\");

        while(b) {
            for (int i = 0; i < copiedLine.length() - 1; i++) {
                char currentChar = copiedLine.charAt(i);
                char nextChar = copiedLine.charAt(i + 1);

                if (currentChar == toFind && nextChar == toFind) {
                    matches++;
                    charIndexesToRemove.add(i);
                    charIndexesToRemove.add(i + 1);

                    i++;
                }

            }

            b = false;
        }

        if (charIndexesToRemove.size() > 0) {
            StringBuilder sb = new StringBuilder(copiedLine);
            sb.deleteCharAt(charIndexesToRemove.get(0));
            copiedLine = sb.toString();

            for (int i = 1; i < charIndexesToRemove.size(); i++) {
                sb = new StringBuilder(copiedLine);
                sb.deleteCharAt(charIndexesToRemove.get(i) - i);
                copiedLine = sb.toString();
            }
        }

        results[0] = copiedLine;
        results[1] = String.valueOf(matches);

        return results;
    }

    private String[] calculateSecondEscape(String line) {
        String copiedLine = line;
        char toFind1 = '\\';
        char toFind2 = '\"';

        String[] results = new String[2];

        ArrayList<Integer> charIndexesToRemove = new ArrayList<>();

        int matches = 0;

        boolean b = copiedLine.contains("\\\"");

        while(b) {
            for (int i = 0; i < copiedLine.length() - 1; i++) {
                char currentChar = copiedLine.charAt(i);
                char nextChar = copiedLine.charAt(i + 1);

                if (currentChar == toFind1 && nextChar == toFind2) {
                    matches++;
                    charIndexesToRemove.add(i);
                    charIndexesToRemove.add(i + 1);

                    i++;
                }

            }

            b = false;
        }

        if (charIndexesToRemove.size() > 0) {
            StringBuilder sb = new StringBuilder(copiedLine);
            sb.deleteCharAt(charIndexesToRemove.get(0));
            copiedLine = sb.toString();

            for (int i = 1; i < charIndexesToRemove.size(); i++) {
                sb = new StringBuilder(copiedLine);
                sb.deleteCharAt(charIndexesToRemove.get(i) - i);
                copiedLine = sb.toString();
            }
        }

        results[0] = copiedLine;
        results[1] = String.valueOf(matches);

        return results;
    }


    private String[] calculateThirdEscape(String line) {
        Pattern pattern = Pattern.compile("\\\\x[0-9a-f][0-9a-f]");
        Matcher matcher = pattern.matcher(line);

        List<String> hexCharacters = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f");

        String copiedLine = line;
        char toFind1 = '\\';
        char toFind2 = 'x';

        String[] results = new String[2];

        ArrayList<Integer> charIndexesToRemove = new ArrayList<>();

        int matches = 0;

        boolean b = matcher.find();

        int length = copiedLine.length();

        while(b) {
            for (int i = 0; i < copiedLine.length() - 3; i++) {
                char currentChar = copiedLine.charAt(i);
                char nextChar = copiedLine.charAt(i + 1);
                char nextChar2 = copiedLine.charAt(i + 2);
                char nextChar3 = copiedLine.charAt(i + 3);

                if (currentChar == toFind1 && nextChar == toFind2 && hexCharacters.contains(String.valueOf(nextChar2)) && hexCharacters.contains(String.valueOf(nextChar3))) {
                    matches++;
                    charIndexesToRemove.add(i);
                    charIndexesToRemove.add(i + 1);
                    charIndexesToRemove.add(i + 2);
                    charIndexesToRemove.add(i + 3);

                    i += 3;
                }
            }

            b = false;
        }

        if (charIndexesToRemove.size() > 0) {
            StringBuilder sb = new StringBuilder(copiedLine);
            sb.deleteCharAt(charIndexesToRemove.get(0));
            copiedLine = sb.toString();

            for (int i = 1; i < charIndexesToRemove.size(); i++) {
                sb = new StringBuilder(copiedLine);
                sb.deleteCharAt(charIndexesToRemove.get(i) - i);
                copiedLine = sb.toString();
            }
        }

        results[0] = copiedLine;
        results[1] = String.valueOf(matches );

        return results;
    }

    public int getSolution() {
        return charsInCode - charsInString;
    }

    public int getCharsInString() {
        return charsInString;
    }

    public int getCharsInCode() {
        return charsInCode;
    }
}
