package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis {
    public static String MOLECULE_TO_FIND;

    public static Map<String, ArrayList<String>> mapPossibleReplacements(List<String> lines) {
        Map<String, ArrayList<String>> replacements = new HashMap<>();

        for (String line : lines) {
            String[] split = line.split(" => ");

            String originalMoleculePart = split[0];
            String newMoleculePart = split[1];

            if (replacements.containsKey(originalMoleculePart)) {
                replacements.get(originalMoleculePart).add(newMoleculePart);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(newMoleculePart);
                replacements.put(originalMoleculePart, arrayList);
            }
        }

        return replacements;
    }

    public static ArrayList<String> getPossibleMoleculesFrom(Map<String, ArrayList<String>> replacements) {
        ArrayList<String> possibleMolecules = new ArrayList<>();

        for (String oldMolecule : replacements.keySet()) {
            ArrayList<String> currentReplacements = replacements.get(oldMolecule);

            List<Integer> matches = countMatches(oldMolecule, MOLECULE_TO_FIND);

            int currentSize = oldMolecule.length();


            for (String newMolecule : currentReplacements) {

                for (Integer match : matches) {
                    String copiedMoleculeToFind = MOLECULE_TO_FIND;

                    int currentIndex = match;

                    StringBuilder stringBuilder = new StringBuilder(copiedMoleculeToFind);

                    stringBuilder.replace(currentIndex, currentIndex + currentSize, newMolecule);

                    String possibleMolecule = stringBuilder.toString();

                    if (!possibleMolecules.contains(possibleMolecule)) {
                        possibleMolecules.add(possibleMolecule);
                    }
                }
            }
        }

        return possibleMolecules;
    }

    private static List<Integer> countMatches(String toFind, String toFindIn) {
        ArrayList<Integer> indexes = new ArrayList<>();

        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = toFindIn.indexOf(toFind, lastIndex);

            if (lastIndex != - 1) {
                indexes.add(lastIndex);
                lastIndex += toFind.length();
            }
        }

        return indexes;
    }
}
