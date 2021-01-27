package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);
        assignMoleculeToFind(lines);
        lines.remove(lines.size() - 1);


        Map<String, ArrayList<String>> replacements = Analysis.mapPossibleReplacements(lines);

        ArrayList<String> possibleMolecules = Analysis.getPossibleMoleculesFrom(replacements);


        System.out.println(possibleMolecules.size());

    }

    public static void assignMoleculeToFind(List<String> lines) {
        Analysis.MOLECULE_TO_FIND = lines.get(lines.size() - 1);
    }
}
