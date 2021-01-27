package com.company;

import java.util.List;
import java.util.Map;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);
        assignMoleculeToFind(lines);
        lines.remove(lines.size() - 1);


        Map<String, String> replacements = Analysis.mapPossibleReplacements(lines);

        int steps = Analysis.getMoleculeToESteps(replacements);

        System.out.println(steps);
    }

    public static void assignMoleculeToFind(List<String> lines) {
        Analysis.MOLECULE_TO_FIND = lines.get(lines.size() - 1);
    }
}
