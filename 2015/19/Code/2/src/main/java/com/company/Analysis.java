package com.company;

import java.util.*;

public class Analysis {
    public static String MOLECULE_TO_FIND;
    public static List<List<String>> replacementCombinations = new ArrayList<>();

    public static Map<String, String> mapPossibleReplacements(List<String> lines) {
        Map<String, String> replacements = new HashMap<>();

        for (String line : lines) {
            String[] split = line.split(" => ");

            String originalMoleculePart = split[1];
            String newMoleculePart = split[0];

            replacements.put(originalMoleculePart, newMoleculePart);
        }

        return replacements;
    }


    public static int getMoleculeToESteps(Map<String, String> replacements) {

        while (true) {

            String moleculeToFind = MOLECULE_TO_FIND;

            int steps = 0;

            calculateCombinations(replacements.keySet().toArray(new String[0]), replacements.keySet().size(), replacements.keySet().size());

            for (List<String> replacement : replacementCombinations) {
                for (String originalString : replacement) {
                    String newString = replacements.get(originalString);

                    steps += countMatches(originalString, moleculeToFind);

                    moleculeToFind = moleculeToFind.replaceAll(originalString, newString);

                    if (moleculeToFind.equals("e")) {
                        return steps;
                    }
                }
            }
        }
    }

    public static void combinationUtil(String[] arr, String[] data, int start, int end, int index, int r) {
        if (index == r) {
            List<String> currentCombination = new ArrayList<>(Arrays.asList(data).subList(0, r));
            replacementCombinations.add(currentCombination);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    public static void calculateCombinations(String[] arr, int n, int r) {
        String[] data =new String[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    private static int countMatches(String toFind, String toFindIn) {
        int count = 0;

        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = toFindIn.indexOf(toFind, lastIndex);

            if (lastIndex != - 1) {
                count++;
                lastIndex += toFind.length();
            }
        }

        return count;
    }
}
